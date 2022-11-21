package com.zhaomeng.factory.abstract1;

/**
 * @author: zhaomeng
 * @Date: 2022/10/11 15:31
 */
// !路由器产品接口
public interface IRouterProduct {

    void start();
    void shutdown();
    void openWIFI();
    void setting();
}
