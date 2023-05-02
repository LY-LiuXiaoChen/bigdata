package com.cj.case2;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class DistributedLock {
    private final String connectionString="hadoop102:2181,hadoop103:2181,hadoop104:2181";
    private final int sessionTimeout=2000;
    private  ZooKeeper zooKeeper;
    private CountDownLatch countDownLatch = new CountDownLatch(1);
    private CountDownLatch waitLatch = new CountDownLatch(1);
    private String waitPath;
    private String currentNodePath;

    //写构造方法，获取连接
    public DistributedLock() throws IOException, InterruptedException, KeeperException {
        zooKeeper = new ZooKeeper(connectionString, sessionTimeout, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                if(watchedEvent.getState()==Event.KeeperState.SyncConnected){
                    countDownLatch.countDown();
                }
                if(watchedEvent.getType()==Event.EventType.NodeDeleted&&watchedEvent.getPath().equals(waitPath)){
                    waitLatch.countDown();
                }
            }
        });
        //等待连接建立
        countDownLatch.await();
        //判断节点是否存在
        Stat stat = zooKeeper.exists("/locks", false);
        if(stat==null){
            String s = zooKeeper.create("/locks", "locks".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        }
    }
    //加锁
    public void zkLock() throws InterruptedException, KeeperException {
        //创建临时节点
        currentNodePath = zooKeeper.create("/locks/seq-", null, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
        Thread.sleep(10);
        //监听
        List<String> children = zooKeeper.getChildren("/locks", false);
        if (children.size()==1) {
            return;
        }else {
            //对接点进行排序
            Collections.sort(children);
            //判断是否为第一个节点
            String currentNodeName = currentNodePath.substring("/locks/".length());
            int index = children.indexOf(currentNodeName);
            if(index==-1){
                System.out.println("数据异常");
            }else if(index==0){
                return;
            }else {
                //监听
                waitPath = "/locks/"+children.get(index - 1);
                zooKeeper.getData(waitPath,true,new Stat());
                //等待
                waitLatch.await();
                return;
            }
        }

    }
    //解锁
    public void unZkLock() throws InterruptedException, KeeperException {
        //System.out.println(currentNodePath);
        zooKeeper.delete(currentNodePath,-1);
    }
}
