package com.zhaomeng.dao;

import com.zhaomeng.pojo.User;
import com.zhaomeng.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author: zhaomeng
 * @Date: 2022/9/18 17:02
 */
public class UserDaoTest {

    @Test
    public void test() {

        // !第一步：获取SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        // !getMapper
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        List<User> userList = userDao.getUserList();

        for (User user : userList) {
            System.out.println(user);
        }

        // !关闭sqlSession
        sqlSession.close();
    }

    @Test
    public void getUserByIdTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserDao mapper = sqlSession.getMapper(UserDao.class);
        User user1 = mapper.getUserById(1);
        System.out.println(user1);

        User user2 = mapper.getUserById(2);
        System.out.println(user2);

        sqlSession.close();
    }


    // !增删改需要提交事务，查不需要
    @Test
    public void addUserTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserDao mapper = sqlSession.getMapper(UserDao.class);
        User user = new User(3, "lisi", "123321");
        mapper.addUser(user);

        sqlSession.commit();

        sqlSession.close();
    }

    @Test
    public void updateUserTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserDao mapper = sqlSession.getMapper(UserDao.class);
        User user = new User(1, "zhaomeng", "123321");
        mapper.updateUser(user);

        sqlSession.commit();

        sqlSession.close();
    }

    @Test
    public void deleteUserTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserDao mapper = sqlSession.getMapper(UserDao.class);
        mapper.deleteUser(3);

        sqlSession.commit();

        sqlSession.close();
    }
}
