package com.zhaomeng.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: zhaomeng
 * @Date: 2022/12/4 17:45
 */
// !newSingleThreadExecutor只有一个核心线程数
public class SingleThreadExecutor {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        for (int i = 0; i < 1000; i++) {
            executorService.execute(() -> System.out.println(Thread.currentThread().getName()));
        }
    }
}
