package com.zhaomeng.threadpool;
/**
* @author: zhaomeng
* @Date: 2022/12/4 16:38
*/public class OneTaskOneThread {

    public static void main(String[] args) {
        Thread thread = new Thread(new Task());
        thread.start();

    }

    static class Task implements Runnable {
        @Override
        public void run() {
            System.out.println("执行了一个任务");
        }
    }
}
