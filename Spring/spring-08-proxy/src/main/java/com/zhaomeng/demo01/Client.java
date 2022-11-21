package com.zhaomeng.demo01;

/**
 * @author: zhaomeng
 * @Date: 2022/10/26 20:25
 */
public class Client {
    public static void main(String[] args) {
//        Host host = new Host();
//        host.rent();

        Host host = new Host();

        Proxy proxy = new Proxy(host);
        proxy.rent();
    }
}
