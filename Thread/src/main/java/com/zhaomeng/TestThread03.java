package com.zhaomeng;

/**
 * @author: zhaomeng
 * @Date: 2022/10/8 15:57
 */
// !创建线程方式2：实现runnable接口，重写run方法，执行线程时需要丢入runnable接口实现类，调用start方法
public class TestThread03 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("i am reading code");
        }
    }

    public static void main(String[] args) {
        // !创建runnable接口的实现类对象
        TestThread03 testThread03 = new TestThread03();

        new Thread(testThread03).start();

        for (int i = 0; i < 20; i++) {
            System.out.println("i am reading books");
        }
    }
}
