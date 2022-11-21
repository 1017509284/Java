package com.zhaomeng;

/**
 * @author: zhaomeng
 * @Date: 2022/10/8 15:29
 */
// !创建线程方式1：继承Thread类，重写run方法，调用start开启线程
public class TestThread01 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("i am reading code");
        }
    }


    // !main线程，主线程
    // !start方法和run方法的区别
    // !run方法：主线程调用run，主线程执行run，执行完run后，返回到调用run的调用口，然后接着执行，本质还是串行调用
    // !start方法：主线程调用run，子线程执行run，主线程和子线程并行交替执行
    public static void main(String[] args) {
        // !创建一个线程对象
        TestThread01 testThread01 = new TestThread01();
        // !调用start方法开启线程
        testThread01.start();
//        testThread01.run();

        System.out.println("i am learning muiltthread");
    }
}
