package com.zhaomeng.factory.simple;

/**
 * @author: zhaomeng
 * @Date: 2022/10/11 15:00
 */
// !简单工厂or静态工厂，不满足开闭原则
public class CarFactory {
    // !方法一
    public static Car getCar(String car) {
        if ("五菱".equals(car)) {
            return new WuLing();
        } else if ("特斯拉".equals(car)) {
            return new Tesla();
        } else {
            return null;
        }
    }

    // !方法二
    public static Car getWuLing() {
        return new WuLing();
    }
    public static Car getTesla() {
        return new Tesla();
    }
}
