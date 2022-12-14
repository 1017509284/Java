package com.zhaomeng.threadlocal;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: zhaomeng
 * @Date: 2022/12/4 20:59
 */
// !2个线程打印日期
public class ThreadLocalNormalUsage00 {

    public static void main(String[] args) {
        new Thread(() -> {
            String date = new ThreadLocalNormalUsage00().date(10);
            System.out.println(date);
        }).start();

        new Thread(() -> {
            String date = new ThreadLocalNormalUsage00().date(1234);
            System.out.println(date);
        }).start();
    }

    public String date(int seconds) {
        // !参数的单位是毫秒
        Date date = new Date(1000 * seconds);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return simpleDateFormat.format(date);
    }
}
