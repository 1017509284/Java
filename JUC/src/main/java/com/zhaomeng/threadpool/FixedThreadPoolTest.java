package com.zhaomeng.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: zhaomeng
 * @Date: 2022/12/4 17:32
 */

// !演示FixedThreadPool
public class FixedThreadPoolTest {
    // !由于FixedThreadPool传进去的LinkedBlockingQueue无界队列是没有容量上线的，所以当请求数越来越多，并且无法即使处理完毕的时候，也就是请求堆积的时候，
    // !会造成大量的内存消耗，可能会导致oom
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        for (int i = 0; i < 100; i++) {
            executorService.execute(new Task());
        }

    }

    static class Task implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName());
        }
    }
}
