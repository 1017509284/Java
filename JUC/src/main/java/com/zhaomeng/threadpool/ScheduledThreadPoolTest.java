package com.zhaomeng.threadpool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author: zhaomeng
 * @Date: 2022/12/4 17:54
 */
public class ScheduledThreadPoolTest {
    public static void main(String[] args) {

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);

        scheduledExecutorService.schedule(() -> System.out.println(Thread.currentThread().getName()), 5, TimeUnit.SECONDS);

    }
}
