package com.zhaomeng;

/**
 * @author: zhaomeng
 * @Date: 2022/5/18 00:59
 */
public class Hello {
    private String str;

    public String getStr() {
        return str;
    }

    //! xml注入的原理就是用set方法
    public void setStr(String str) {
        this.str = str;
    }

    @Override
    public String toString() {
        return "Hello{" +
                "str='" + str + '\'' +
                '}';
    }
}
