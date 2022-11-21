package com.zhaomeng;

import java.lang.annotation.*;

/**
 * @author: zhaomeng
 * @Date: 2022/10/10 22:25
 */
public class Reflection07 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        Class c1 = Class.forName("com.zhaomeng.Student2");
        // !通过Class对象获取Student2类上的注解
        for (Annotation annotation : c1.getAnnotations()) {
            System.out.println(annotation);
        }

        // !获取注解上的value值
        Clazz clazz = (Clazz) c1.getAnnotation(Clazz.class);
        String value = clazz.value();
        System.out.println(value);

        // !获得类的指定的注解
        java.lang.reflect.Field field = c1.getDeclaredField("name");
        Field annotation = field.getAnnotation(Field.class);
        System.out.println(annotation.columnName());
        System.out.println(annotation.type());
        System.out.println(annotation.length());


    }
}


@Clazz("db_student")
class Student2 {
    @Field(columnName = "db_id", type = "int", length = 10)
    private int id;
    @Field(columnName = "db_age", type = "int", length = 10)
    private int age;
    @Field(columnName = "db_name", type = "varchar", length = 10)
    private String name;

    public Student2() {
    }

    public Student2(int id, int age, String name) {
        this.id = id;
        this.age = age;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student2{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}


// !类名的注解
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface Clazz {
    String value();
}


// !属性的注解
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface Field {
    String columnName();
    String type();
    int length();
}