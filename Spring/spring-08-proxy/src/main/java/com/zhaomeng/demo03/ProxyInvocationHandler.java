package com.zhaomeng.demo03;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author: zhaomeng
 * @Date: 2022/10/26 21:07
 */
// !我们会用这个类，自动生成代理
public class ProxyInvocationHandler implements InvocationHandler {

    private Rent rent;
    // !被代理的接口
    public void setRent(Rent rent) {
        this.rent = rent;
    }
    // !生成得到代理类
    public Object getProxy() {
        return Proxy.newProxyInstance(this.getClass().getClassLoader(), rent.getClass().getInterfaces(), this);
    }
    // !处理代理实例，并返回结果
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // !动态代理的本质，就是使用反射机制实现
        return method.invoke(rent, args);
    }
}
