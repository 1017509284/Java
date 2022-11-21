package com.zhaomeng.factory.method;

/**
 * @author: zhaomeng
 * @Date: 2022/10/11 15:18
 */
public class WuLingFactory implements CarFactory{
    @Override
    public Car getCar() {
        return new WuLing();
    }
}
