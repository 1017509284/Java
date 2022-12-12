package com.zhaomeng.threadlocal;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: zhaomeng
 * @Date: 2022/12/4 20:59
 */
// !演示threadLocal用法2，避免参数传递的麻烦
public class ThreadLocalNormalUsage06 {
    public static void main(String[] args) {
        new Service1().process();
    }
}
class Service1 {
    public void process() {
        User user = new User("赵萌");
        // !将拿到的参数set到threadlocal中
        UserContextHolder.holder.set(user);
        new Service2().process();
    }
}
class Service2 {
    public void process() {
        // !从threadLocal中get出上一步set的值
        User user = UserContextHolder.holder.get();
        System.out.println("service2拿到用户名：" + user.name);
        new Service3().process();
    }
}
class Service3 {
    public void process() {
        User user = UserContextHolder.holder.get();
        System.out.println("service3拿到用户名：" + user.name);
    }
}
class UserContextHolder {
    public static ThreadLocal<User> holder = new ThreadLocal<>();
}
class User {
    String name;

    public User(String name) {
        this.name = name;
    }
}