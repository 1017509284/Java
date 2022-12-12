package com.zhaomeng.threadlocal;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: zhaomeng
 * @Date: 2022/12/4 20:59
 */
// !用线程池来完成1000个打印日期的任务
// !加锁来解决线程安全问题
public class ThreadLocalNormalUsage04 {

    public static ExecutorService threadPool = Executors.newFixedThreadPool(10);
    static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 30; i++) {
            int finalI = i;
            threadPool.submit(() -> {
                String date = new ThreadLocalNormalUsage04().date(finalI);
                System.out.println(date);
            });
        }
        threadPool.shutdown();
    }

    public String date(int seconds) {
        // !参数的单位是毫秒
        Date date = new Date(1000 * seconds);
        String s = null;
        // !对此段代码进行加锁
        synchronized (ThreadLocalNormalUsage04.class) {
            s = simpleDateFormat.format(date);
        }
        return s;
    }
}
