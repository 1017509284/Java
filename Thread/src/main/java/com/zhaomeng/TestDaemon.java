package com.zhaomeng;

/**
 * @author: zhaomeng
 * @Date: 2022/10/9 14:48
 */
// !守护线程
public class TestDaemon {
    public static void main(String[] args) {
        God god = new God();
        Me me = new Me();

        Thread thread = new Thread(god);
        // !设置守护线程 默认为false true表示设置为守护线程
        thread.setDaemon(true);
        thread.start();

        new Thread(me).start();
    }
}

class God implements Runnable {
    @Override
    public void run() {
        // !守护线程必须得等待用户线程执行完之后，才会退出，因此即使，写的死循环，依旧会在Me类中的run方法执行完之后结束守护线程
        while (true) {
            System.out.println("God Bless You");
        }
    }
}

class Me implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("this is my " + i + "th years");
        }
    }
}
