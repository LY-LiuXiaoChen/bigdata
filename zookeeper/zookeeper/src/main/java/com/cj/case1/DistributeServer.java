package com.cj.case1;

import org.apache.zookeeper.*;
import org.apache.zookeeper.ZooDefs.Ids;
import java.io.IOException;

//服务端
public class DistributeServer {
    private String connectString="hadoop102:2181,hadoop103:2181,hadoop104:2181";
    private int sessionTimeout=2000;
    private ZooKeeper zooKeeper;

    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
        DistributeServer server = new DistributeServer();
        //创建连接
        server.getConnection();
        //注册服务器
        server.regist(args[0]);
        //业务逻辑
        server.business();
    }

    private void business() throws InterruptedException {
        Thread.sleep(Long.MAX_VALUE);
    }

    private void regist(String hostname) throws InterruptedException, KeeperException {
        String createNode = zooKeeper.create("/servers/" + hostname, hostname.getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
        System.out.println(hostname+"已上线"+createNode);
    }

    private void getConnection() throws IOException {
        zooKeeper = new ZooKeeper(connectString, sessionTimeout, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {

            }
        });
    }
}
