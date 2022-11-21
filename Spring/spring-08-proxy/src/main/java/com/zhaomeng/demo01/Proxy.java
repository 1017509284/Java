package com.zhaomeng.demo01;

/**
 * @author: zhaomeng
 * @Date: 2022/10/26 20:26
 */
public class Proxy {

    private Host host;

    public Proxy() {
    }

    public Proxy(Host host) {
        this.host = host;
    }

    public void rent() {
        seeHouse();
        fare();
        hetong();
        host.rent();
    }

    public void seeHouse() {
        System.out.println("中介带你看房");
    }

    public void hetong() {
        System.out.println("和中介签租赁合同");
    }

    public void fare() {
        System.out.println("收中介费");
    }

}
