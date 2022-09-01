package com.zhaomeng;

/**
 * @author: zhaomeng
 * @Date: 2022/5/18 01:56
 */
public class UserT {

    private String name;

    public UserT() {
        System.out.println("UserT被创建了");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void show() {
        System.out.println("name = " + name);
    }
}
