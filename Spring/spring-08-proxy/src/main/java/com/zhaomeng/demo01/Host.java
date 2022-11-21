package com.zhaomeng.demo01;

/**
 * @author: zhaomeng
 * @Date: 2022/10/26 20:24
 */
public class Host implements Rent{
    @Override
    public void rent() {
        System.out.println("房东要出租房屋了！");
    }
}
