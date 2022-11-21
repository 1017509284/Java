package com.zhaomeng.Singlethon;

/**
 * @author: zhaomeng
 * @Date: 2022/10/10 23:47
 */
// !饿汉式单例模式
public class Hungry {

    //可能会浪费空间，因为一上来就加载了如下四个变量，占了内存
    private byte[] data1 = new byte[1024 * 1024];
    private byte[] data2 = new byte[1024 * 1024];
    private byte[] data3 = new byte[1024 * 1024];
    private byte[] data4 = new byte[1024 * 1024];
    private Hungry() {

    }

    private final static Hungry HUNGRY = new Hungry();

    public static Hungry getInstance() {
        return HUNGRY;
    }

}
