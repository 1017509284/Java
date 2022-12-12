package com.zhaomeng.lock.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: zhaomeng
 * @Date: 2022/12/5 18:20
 */
// !用trylock来避免死锁
public class TryLockDeadLock implements Runnable{
    int flag = 1;

    static Lock lock1 = new ReentrantLock();
    static Lock lock2 = new ReentrantLock();

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (flag == 1) {
                try {
                    if (lock1.tryLock(800, TimeUnit.SECONDS)) {
                        try {
                            System.out.println("线程："+ Thread.currentThread().getName() + "获取到了锁1");
                            Thread.sleep(1000);

                            if (lock2.tryLock(800, TimeUnit.SECONDS)) {
                                try {
                                    System.out.println("线程:" + Thread.currentThread().getName() + "获取到了锁2");
                                    System.out.println("线程:" + Thread.currentThread().getName() + "获取到了两把锁");
                                    break;
                                } finally {
                                    lock2.unlock();
                                }
                            } else {
                                System.out.println(Thread.currentThread().getName() + "获取锁2失败，已经重试");
                            }
                        } finally {
                            lock1.unlock();
                            Thread.sleep(1000);
                        }
                    } else {
                        System.out.println(Thread.currentThread().getName() + "获取锁1失败，已经重试");
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
