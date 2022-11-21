package com.zhaomeng;

/**
 * @author: zhaomeng
 * @Date: 2022/10/8 21:49
 */
// !测试线程join
public class TestJoin implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("线程vip来了" + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {

        TestJoin testJoin = new TestJoin();
        Thread thread = new Thread(testJoin);
        thread.start();

        for (int i = 0; i < 500; i++) {
            if (i == 200) {
                thread.join(); // 插队,待此线程执行完后，再执行其他线程，其他线程阻塞
            }
            System.out.println("main" + i);
        }
    }
}
