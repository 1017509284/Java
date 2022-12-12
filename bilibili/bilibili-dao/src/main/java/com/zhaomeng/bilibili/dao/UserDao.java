package com.zhaomeng.bilibili.dao;

import com.zhaomeng.bilibili.domain.User;
import com.zhaomeng.bilibili.domain.UserInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author: zhaomeng
 * @Date: 2022/11/27 16:56
 */

@Mapper
public interface UserDao {

    User getUserByPhone(String phone);

    Integer addUser(User user);

    Integer addUserInfo(UserInfo userInfo);

    User getUserById(Long id);

    UserInfo getUserInfoByUserId(Long id);

    void updateUsers(User user);

    Integer updateUserInfos(UserInfo userInfo);
}
