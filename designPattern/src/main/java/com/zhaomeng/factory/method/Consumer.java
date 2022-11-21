package com.zhaomeng.factory.method;

/**
 * @author: zhaomeng
 * @Date: 2022/10/11 14:57
 */
public class Consumer {
    public static void main(String[] args) {
        Car car = new WuLingFactory().getCar();
        Car car1 = new TeslaFactory().getCar();

        car.name();
        car1.name();
    }
}
