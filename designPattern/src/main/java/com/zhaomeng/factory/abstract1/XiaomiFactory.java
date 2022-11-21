package com.zhaomeng.factory.abstract1;

/**
 * @author: zhaomeng
 * @Date: 2022/10/11 15:41
 */
public class XiaomiFactory implements IProductFactory{

    @Override
    public IphoneProduct iphoneProduct() {
        return new XiaomiPhone();
    }

    @Override
    public IRouterProduct routerProduct() {
        return new XiaomiRouter();
    }
}
