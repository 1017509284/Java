package com.zhaomeng.threadlocal;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: zhaomeng
 * @Date: 2022/12/4 20:59
 */
// !30个线程打印日期
public class ThreadLocalNormalUsage01 {

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 30; i++) {
            int finalI = i;
            new Thread(() -> {
                String date = new ThreadLocalNormalUsage01().date(finalI);
                System.out.println(date);
            }).start();

            Thread.sleep(100);
        }
    }

    public String date(int seconds) {
        // !参数的单位是毫秒
        Date date = new Date(1000 * seconds);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return simpleDateFormat.format(date);
    }
}
