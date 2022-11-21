package com.zhaomeng.diy;

/**
 * @author: zhaomeng
 * @Date: 2022/10/27 23:27
 */
public class DiyPointCut {
    public void before() {
        System.out.println("======方法执行前=====");
    }

    public void after() {
        System.out.println("=====方法执行后=====");
    }
}
