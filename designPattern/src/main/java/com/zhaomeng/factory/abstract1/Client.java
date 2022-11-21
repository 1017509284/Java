package com.zhaomeng.factory.abstract1;

/**
 * @author: zhaomeng
 * @Date: 2022/10/11 15:44
 */
public class Client {
    public static void main(String[] args) {
        System.out.println("==============小米系列产品==============");
        XiaomiFactory xiaomiFactory = new XiaomiFactory();
        IphoneProduct iphoneProduct = xiaomiFactory.iphoneProduct();
        iphoneProduct.callup();
        iphoneProduct.sendSMS();

        IRouterProduct iRouterProduct = xiaomiFactory.routerProduct();
        iRouterProduct.openWIFI();
    }
}
