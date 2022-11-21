package com.zhaomeng;

/**
 * @author: zhaomeng
 * @Date: 2022/10/9 18:08
 */
// !测试Class类的创建方式有哪些
public class Reflection02 {
    public static void main(String[] args) throws ClassNotFoundException {
        Person person = new Student();
        System.out.println("这个人是："+ person.name);

        // !方式一：通过对象获得
        Class c1 = person.getClass();
        System.out.println("c1's hashcode : " + c1.hashCode());

        // !方式二：通过forname获得
        Class c2 = Class.forName("com.zhaomeng.Student");
        System.out.println("c2's hashcode : " + c2.hashCode());

        // !方式三：通过类名.class获得
        Class c3 = Student.class;
        System.out.println("c3's hashcode : " + c3.hashCode());

        // !获取父类Class类型
        Class c5 = c1.getSuperclass();
        System.out.println(c5);
    }
}


class Person {
    public String name;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}

class Student extends Person {
    public Student() {
        this.name = "学生";
    }
}

class Teacher extends Person {
    public Teacher() {
        this.name = "老师";
    }
}
