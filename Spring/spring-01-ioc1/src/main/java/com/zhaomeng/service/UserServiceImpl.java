package com.zhaomeng.service;

import com.zhaomeng.dao.UserDao;
import com.zhaomeng.dao.UserDaoImpl;

/**
 * @author: zhaomeng
 * @Date: 2022/5/17 23:36
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    //! 利用set进行动态实现值的注入
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void getUser() {
        userDao.getUser();
    }
}
