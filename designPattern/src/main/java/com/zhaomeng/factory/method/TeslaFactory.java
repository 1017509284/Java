package com.zhaomeng.factory.method;

/**
 * @author: zhaomeng
 * @Date: 2022/10/11 15:18
 */
public class TeslaFactory implements CarFactory{
    @Override
    public Car getCar() {
        return new Tesla();
    }
}
