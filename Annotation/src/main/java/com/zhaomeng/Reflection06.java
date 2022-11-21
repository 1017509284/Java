package com.zhaomeng;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: zhaomeng
 * @Date: 2022/10/10 22:15
 */
// !反射方法invoke和普通invoke和关闭检测后的invoke耗时对比
public class Reflection06 {
    // !普通方式执行
    public static void test01() {
        User user = new User();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            user.getName();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("普通方式执行 ： " + (endTime - startTime) + " ms");
    }

    // !反射方式执行
    public static void test02() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class c1 = Class.forName("com.zhaomeng.User");
        Method getName = c1.getMethod("getName", null);
        User user = (User) c1.newInstance();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            getName.invoke(user);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("反射方式执行 ： " + (endTime - startTime) + " ms");
    }

    // !反射方式执行 关闭检测
    public static void test03() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class c1 = Class.forName("com.zhaomeng.User");
        Method getName = c1.getMethod("getName", null);
        getName.setAccessible(true);
        User user = (User) c1.newInstance();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            getName.invoke(user);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("关闭检测后，反射方式执行 ： " + (endTime - startTime) + " ms");
    }

    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        test01();
        test02();
        test03();
        /**
         * 普通方式执行 ： 5 ms
         * 反射方式执行 ： 115 ms
         * 关闭检测后，反射方式执行 ： 51 ms
         */
    }
}
