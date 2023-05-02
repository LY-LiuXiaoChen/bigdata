package com.cj.zk;

import org.apache.zookeeper.*;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.data.Stat;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class zkClient {
    //逗号左右不能有空格，乌龟的屁股
    private String connectString = "hadoop102:2181,hadoop103:2181,hadoop104:2181";
    private int sessionTimeout = 2000;
    private ZooKeeper zooKeeper;
    //创建客户端
    @Before
    public void init() throws IOException {
        zooKeeper = new ZooKeeper(connectString, sessionTimeout, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                /*List<String> children = null;
                try {
                    children = zooKeeper.getChildren("/", true);
                } catch (KeeperException e) {
                    throw new RuntimeException(e);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                for (String child : children) {
                    System.out.println(child);
                }
                System.out.println("--------------------");*/
            }
        });
    }
    //创建子节点
    @Test
    public void create() throws InterruptedException, KeeperException {
        String noteCreated = zooKeeper.create("/sanguo", "luoguanzhong".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
    }
    //获取子节点并监听节点变化
    @Test
    public void getChildren() throws InterruptedException, KeeperException {
        List<String> children = zooKeeper.getChildren("/", true);
        /*System.out.println("--------------------");
        for (String child : children) {
            System.out.println(child);
        }
        System.out.println("--------------------");*/

        Thread.sleep(Long.MAX_VALUE);
    }

    //判断节点是否存在
    @Test
    public void exist() throws InterruptedException, KeeperException {
        Stat stat = zooKeeper.exists("/cj", false);
        System.out.println(stat==null?"不存在":"存在");
    }
}


