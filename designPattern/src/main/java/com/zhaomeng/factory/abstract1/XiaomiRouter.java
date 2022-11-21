package com.zhaomeng.factory.abstract1;

/**
 * @author: zhaomeng
 * @Date: 2022/10/11 15:35
 */
// !小米路由器
public class XiaomiRouter implements IRouterProduct{

    @Override
    public void start() {
        System.out.println("打开小米路由器");
    }

    @Override
    public void shutdown() {
        System.out.println("关闭小米路由器");
    }

    @Override
    public void openWIFI() {
        System.out.println("小米路由器打开wifi");
    }

    @Override
    public void setting() {
        System.out.println("小米路由器设置");
    }
}
