package com.zhaomeng.factory.simple;

/**
 * @author: zhaomeng
 * @Date: 2022/10/11 14:57
 */
public class Consumer {
    public static void main(String[] args) {
        // !自己造车，不符合买车的场景，买车应该是直接去工厂里面拿即可
        Car car = new WuLing();
        Car car1 = new Tesla();

        car.name();
        car1.name();


        // !直接使用工厂创建
        Car car2 = CarFactory.getCar("五菱");
        Car car3 = CarFactory.getCar("特斯拉");

        car2.name();
        car3.name();
    }
}
