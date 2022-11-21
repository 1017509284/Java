package com.zhaomeng;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: zhaomeng
 * @Date: 2022/10/10 20:35
 */
public class Reflection05 {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        // !获取User类的Class对象
        Class c1 = Class.forName("com.zhaomeng.User");

        // !构造一个对象,本质上时调用了类的无参构造器
        User user = (User) c1.newInstance();
        System.out.println(user);

        // !用构造器进行创建对象
        Constructor constructor = c1.getDeclaredConstructor(String.class, int.class, int.class);
        User user1 = (User) constructor.newInstance("zhaomeng", 1, 24);
        System.out.println(user1);

        // !通过反射调用普通的方法
        User user3 = (User) c1.newInstance();
        // !通过反射获取一个方法
        Method setName = c1.getDeclaredMethod("setName", String.class);
        setName.invoke(user3, "xiaolin");
        System.out.println(user3);

        // !通过反射操作属性
        User user4 = (User) c1.newInstance();
        Field name = c1.getDeclaredField("name");
        // !需要避免验证private才可以修改字段
        name.setAccessible(true);
        // !由于name属性是private的，因此不能直接改，必须设置setAccessible为true才可以修改
        name.set(user4, "xiaozhao");
        System.out.println(user4);

    }
}
