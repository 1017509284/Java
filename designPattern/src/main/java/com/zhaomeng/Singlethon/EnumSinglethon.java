package com.zhaomeng.Singlethon;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author: zhaomeng
 * @Date: 2022/10/11 00:34
 */
// !枚举单例，一定安全,反射不能破坏枚举
public enum EnumSinglethon {

    INSTANCE;

    public EnumSinglethon getInstance() {
        return INSTANCE;
    }
}

// !测试反射能否破坏枚举单例的安全
class Test {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        EnumSinglethon instance = EnumSinglethon.INSTANCE;
//        Constructor<EnumSinglethon> constructor = EnumSinglethon.class.getDeclaredConstructor(null);
        Constructor<EnumSinglethon> constructor = EnumSinglethon.class.getDeclaredConstructor(String.class, int.class);
        constructor.setAccessible(true);
        EnumSinglethon instance1 = constructor.newInstance();

        System.out.println(instance);
        System.out.println(instance1);

        // Exception in thread "main" java.lang.IllegalArgumentException: Cannot reflectively create enum objects
        //	at java.lang.reflect.Constructor.newInstance(Constructor.java:417)
    }
}