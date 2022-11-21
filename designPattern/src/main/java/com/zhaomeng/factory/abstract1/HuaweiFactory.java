package com.zhaomeng.factory.abstract1;

/**
 * @author: zhaomeng
 * @Date: 2022/10/11 15:42
 */
public class HuaweiFactory implements IProductFactory{

    @Override
    public IphoneProduct iphoneProduct() {
        return new HuaweiPhone();
    }

    @Override
    public IRouterProduct routerProduct() {
        return new HuaweiRouter();
    }
}
