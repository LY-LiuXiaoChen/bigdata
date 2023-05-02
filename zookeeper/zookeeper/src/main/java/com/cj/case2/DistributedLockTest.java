package com.cj.case2;

import org.apache.zookeeper.KeeperException;

import java.io.IOException;

public class DistributedLockTest {
    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
        final DistributedLock lock1 = new DistributedLock();
        final DistributedLock lock2 = new DistributedLock();
        //线程1
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lock1.zkLock();
                    System.out.println("线程1启动，获取锁");
                    Thread.sleep(5*1000);
                    lock1.unZkLock();
                    System.out.println("线程1，释放锁");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } catch (KeeperException e) {
                    throw new RuntimeException(e);
                }


            }
        }).start();

        //线程2
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lock2.zkLock();
                    System.out.println("线程2启动，获取锁");
                    Thread.sleep(5*1000);
                    lock2.unZkLock();
                    System.out.println("线程2，释放锁");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } catch (KeeperException e) {
                    throw new RuntimeException(e);
                }


            }
        }).start();

    }
}
