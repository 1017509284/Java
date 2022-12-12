package com.zhaomeng.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: zhaomeng
 * @Date: 2022/12/4 17:48
 */
// !CacheThreadPool
// !可缓存线程池，特点：无界线程池，具有自动回收多余线程的功能
// !maxpoolsize为MAX_VALUE，可能导致非常多的线程，甚至oom
public class CacheThreadPoolTest {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < 10000; i++) {
            executorService.execute(() -> System.out.println(Thread.currentThread().getName()));
        }
    }
}
