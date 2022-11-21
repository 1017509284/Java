package com.zhaomeng;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author: zhaomeng
 * @Date: 2022/10/9 16:51
 */
// !自定义注解
public class Annotation02 {
    // !注解没有顺序，可以先写age，再写name
    @MyAnnotation2(name = "zhaomeng", age = 22)
//!    如果参数有default值的话，那么括号中可以不写
//    @MyAnnotation2()
    public void test() {}

    // !如果注解的参数名为calue，则可以不写value，直接在括号中写即可
    @MyAnnotation3("zhaomeng")
    public void test01() {}
}


/**
 * @author zhaomeng
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation2 {
    // !注解的参数：参数类型 + 参数名();
    // !default：如果不写，默认为""
    String name() default "";
    int age();
    // !如果default为-1的话表示不存在
    int id() default -1;
    String[] schools() default {"MIT", "TINGSHUA", "PKU"};
}


/**
 * @author zhaomeng
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation3 {
    String value();
}