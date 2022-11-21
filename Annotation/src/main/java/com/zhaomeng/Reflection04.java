package com.zhaomeng;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author: zhaomeng
 * @Date: 2022/10/10 19:58
 */
public class Reflection04 {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException {
        // !获取User类的Class对象
        Class c1 = Class.forName("com.zhaomeng.User");

        System.out.println(c1.getName());
        System.out.println(c1.getSimpleName());

        // !获取User对象的字段名集合，只能找到public属性的字段
//        Field field1 = c1.getField();
        // !获取User对象的字段名集合，可以找到所有属性的字段
        Field[] fields = c1.getDeclaredFields();
        // !打印每个字段
        for (Field field : fields) {
            System.out.println(field);
        }

        // !获取User中的name属性
        Field name = c1.getDeclaredField("name");
        System.out.println(name);

        // !可以打印出继承的父类的方法，如Object类的方法
        for (Method method : c1.getMethods()) {
            System.out.println("getMethods() : " + method);
        }

        // !获得本类的所有方法
        for (Method declaredMethod : c1.getDeclaredMethods()) {
            System.out.println("getDeclaredMethods() : " + declaredMethod);
        }

        Method getName = c1.getMethod("getName", null);
        Method setName = c1.getMethod("setName", String.class);
        System.out.println(getName);
        System.out.println(setName);


        // !获取public的构造器
        for (Constructor constructor : c1.getConstructors()) {
            System.out.println(constructor);
        }

        // !获取全部的构造器
        for (Constructor declaredConstructor : c1.getDeclaredConstructors()) {
            System.out.println(declaredConstructor);
        }
    }
}
