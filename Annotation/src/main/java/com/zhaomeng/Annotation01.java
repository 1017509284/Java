package com.zhaomeng;

import java.lang.annotation.*;

/**
 * @author: zhaomeng
 * @Date: 2022/10/9 16:39
 */
// !ElementType.METHOD只表示此注解的使用范围是方法维度，而非class维度，如果要用在class上，在target中添加TYPE的枚举
//@MyAnnotation
public class Annotation01 {

    // !ElementType.METHOD标识了，此注解可以在方法上使用
    @MyAnnotation
    public void test() {

    }
}


// !Target表示我们的注解可以使用的范围，是method还是class或者其他，详见枚举类型
// !ElementType.METHOD表示此注解可以在方法上使用
// !Retention表示此注解的生效范围是源码级别（source）还是运行时（RUNTIME）
// !生效范围：runtime > calss > sources，如果定义runtime，那么在class和sources都生效
// !Documented表示是否将我们的注解生成在JAVAdoc中
// !Inherited表示子类可以继承父类的注解
@Target(value = ElementType.METHOD)
@Retention(value = RetentionPolicy.RUNTIME)
@Documented
@Inherited
@interface MyAnnotation {

}