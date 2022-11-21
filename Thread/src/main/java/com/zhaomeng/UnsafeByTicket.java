package com.zhaomeng;

/**
 * @author: zhaomeng
 * @Date: 2022/10/9 14:59
 */
// !线程同步和锁的使用
public class UnsafeByTicket {
    public static void main(String[] args) {
        BuyTicket buyTicket = new BuyTicket();

        new Thread(buyTicket, "a").start();
        new Thread(buyTicket, "b").start();
        new Thread(buyTicket, "c").start();
    }

}

class BuyTicket implements Runnable {
    private int ticketNums = 10;
    boolean flag = true;

    @Override
    public void run() {
        while (flag) {
            try {
                buy();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    // !加上synchronized，为同步方法
    private synchronized void buy() throws InterruptedException {
        if (ticketNums <= 0) {
            flag = false;
            return;
        }
        Thread.sleep(100);
        System.out.println(Thread.currentThread().getName() + "买到了第" + ticketNums-- + "张票");
    }
}
