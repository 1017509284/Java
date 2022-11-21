package com.zhaomeng.Singlethon;

/**
 * @author: zhaomeng
 * @Date: 2022/10/11 00:14
 */
// !静态内部类实现单例(不安全)
public class Holder {
    private Holder() {

    }

    public static Holder getInstance() {
        return InnerClass.HOLDER;
    }

    public static class InnerClass {
        private static final Holder HOLDER = new Holder();
    }
}
