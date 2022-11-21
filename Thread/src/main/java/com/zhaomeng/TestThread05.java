package com.zhaomeng;

import java.util.Objects;

/**
 * @author: zhaomeng
 * @Date: 2022/10/8 16:30
 */
// !模拟龟兔赛跑
public class TestThread05 implements Runnable{
    private static String winner;

    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            // !模拟兔子休息
            if (Objects.equals(Thread.currentThread().getName(), "兔子") && i % 10 == 0) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            // !判断比赛是否结束
            boolean flag = gameOver(i);
            // !如果结束了，就停止程序
            if (flag) {
                break;
            }
            System.out.println(Thread.currentThread().getName() + "-->跑了" + i + "步");
        }
    }

    // !判断比赛是否结束
    private boolean gameOver(int steps) {
        if (winner != null) {
            return true;
        } else if (steps >= 100) {
            winner = Thread.currentThread().getName();
            System.out.println("winner is " + winner);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        TestThread05 testThread05 = new TestThread05();

        new Thread(testThread05, "乌龟").start();
        new Thread(testThread05, "兔子").start();
    }
}
