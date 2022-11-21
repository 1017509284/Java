package com.zhaomeng.log;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @author: zhaomeng
 * @Date: 2022/10/27 23:02
 */
public class BeforeLog implements MethodBeforeAdvice {
    // !method：要执行的目标对象的方法
    // !args：参数
    // !target：目标对象
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println(target.getClass().getName() + "的" + method.getName() + "被执行了");
    }
}
