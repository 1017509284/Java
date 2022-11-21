package com.zhaomeng.pojo;

/**
 * @author: zhaomeng
 * @Date: 2022/10/26 15:49
 */
public class Address {
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Address{" +
                "address='" + address + '\'' +
                '}';
    }
}
