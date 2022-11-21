package com.zhaomeng.factory.abstract1;

/**
 * @author: zhaomeng
 * @Date: 2022/10/11 15:37
 */
// !华为路由器
public class HuaweiRouter implements IRouterProduct{
    @Override
    public void start() {
        System.out.println("打开华为路由器");
    }

    @Override
    public void shutdown() {
        System.out.println("关闭华为路由器");
    }

    @Override
    public void openWIFI() {
        System.out.println("华为路由器打开wifi");
    }

    @Override
    public void setting() {
        System.out.println("华为路由器设置");
    }
}
