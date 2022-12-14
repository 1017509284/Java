package com.zhaomeng;

/**
 * @author: zhaomeng
 * @Date: 2022/10/9 17:57
 */
public class Reflection01 {
    public static void main(String[] args) throws ClassNotFoundException {
        // !通过反射获得User类的class对象
        // !一个类在内存中只有一个Class对象
        // !一个类被加载后，类的整个结构都会被封装在Class对象中
        Class c1 = Class.forName("com.zhaomeng.User");
        System.out.println(c1);
    }
}
class User {

    private String name;
    private int id;
    private int age;


    public User(String name, int id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", age=" + age +
                '}';
    }
}