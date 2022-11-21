package com.zhaomeng.factory.abstract1;

/**
 * @author: zhaomeng
 * @Date: 2022/10/11 15:40
 */
// !抽象产品工厂
public interface IProductFactory {
    // !生产手机
    IphoneProduct iphoneProduct();

    // !生产路由器
    IRouterProduct routerProduct();
}
