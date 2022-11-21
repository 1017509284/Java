package com.zhaomeng;

/**
 * @author: zhaomeng
 * @Date: 2022/10/8 16:07
 */
// !并发抢票case，存在并发问题，导致一个票被多个人抢到
public class TestThread04 implements Runnable{

    private int ticketNums = 10;

    @Override
    public void run() {
        while(true) {
            if (ticketNums <= 0) {
                break;
            }
            // !模拟延时
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + "-->拿到了第" + ticketNums-- + "张票");
        }
    }

    public static void main(String[] args) {
        TestThread04 testThread04 = new TestThread04();

        new Thread(testThread04, "小明").start();
        new Thread(testThread04, "老师").start();
        new Thread(testThread04, "黄牛党").start();
    }
}
