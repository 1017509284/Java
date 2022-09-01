package com.zhaomeng.dao;

/**
 * @author: zhaomeng
 * @Date: 2022/5/17 23:41
 */
public class UserDaoMysqlImpl implements UserDao {
    @Override
    public void getUser() {
        System.out.println("Mysql获取数据");
    }
}
