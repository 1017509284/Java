package com.zhaomeng;

/**
 * @author: zhaomeng
 * @Date: 2022/10/8 17:10
 */
// !静态代理模式
// !真实对象和代理对象都要事先同一个接口
// !代理对象要代理真实角色
public class TestThread07 {
    public static void main(String[] args) {
        WeddingCompany weddingCompany = new WeddingCompany(new Zhaomeng());
        weddingCompany.marry();
    }
}

interface Marry {
    void marry();
}

// !真实角色
class Zhaomeng implements Marry {
    @Override
    public void marry() {
        System.out.println("zhaomeng要结婚了，超开心");
    }
}

class WeddingCompany implements Marry {
    // !目标结婚对象
    private Marry target;

    public WeddingCompany(Marry target) {
        this.target = target;
    }

    @Override
    public void marry() {
        this.target.marry();
    }
}

