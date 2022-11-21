package com.zhaomeng.dao;

import com.zhaomeng.pojo.User;

import java.util.List;

/**
 * @author: zhaomeng
 * @Date: 2022/9/18 16:52
 */
public interface UserDao {

    // !查询全部用户信息
    List<User> getUserList();

    // !根据id查询用户
    User getUserById(int id);

    // !添加一个用户
    int addUser(User user);

    // !更新一个用户
    int updateUser(User user);

    // !删除一个用户
    int deleteUser(int id);
}
