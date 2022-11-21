package com.zhaomeng.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author: zhaomeng
 * @Date: 2022/10/26 18:03
 */

// !@Component等价于<bean id="user" class="com.zhaomeng.pojo.User"/>
// !相当于将user这个bean注入到容器中，后面就可以从spring容器中get出来
@Component
public class User {
    // !使用@Value注解可以给一个未赋值的值进行赋值
    // !相当于<property name = "name" value = "zhaomeng"/>
    @Value("zhaomeng")
    public String name;
}
