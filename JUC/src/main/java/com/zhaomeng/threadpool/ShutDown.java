package com.zhaomeng.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: zhaomeng
 * @Date: 2022/12/4 18:09
 */
// !关闭线程池
public class ShutDown {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 100; i++) {
            executorService.execute(new Task());
        }

        Thread.sleep(1500);
        // !返回false
        System.out.println(executorService.isShutdown());
        // !关闭线程池，会先执行完存量的任务，增量的任务直接拒绝
        executorService.shutdown();
        // !返回true，并继续执行存量任务
        System.out.println(executorService.isShutdown());
        // !此次提交任务会直接被拒绝
        executorService.execute(new Task());

        // !判断整个线程池是否都结束了
        System.out.println(executorService.isTerminated());
    }
    static class Task implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(500);
                System.out.println(Thread.currentThread().getName());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}


