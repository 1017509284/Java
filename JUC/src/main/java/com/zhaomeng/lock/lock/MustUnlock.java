package com.zhaomeng.lock.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: zhaomeng
 * @Date: 2022/12/5 18:15
 */
// !Lock不会像synchronized一样，异常的时候自动释放锁，所以最佳实践是，finally中释放锁，以保证发生异常的时候锁一定被释放
public class MustUnlock {
    private static Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        // !lock()方法不能被中断，一旦陷入死锁，lock()就会陷入永久等待
        lock.lock();
        try {
            // !获取锁保护的资源
            System.out.println(Thread.currentThread().getName() + "开始执行任务");
        } finally {
            lock.unlock();
        }
    }
}
