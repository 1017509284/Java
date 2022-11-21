package com.zhaomeng.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author: zhaomeng
 * @Date: 2022/9/18 16:35
 */

// !通过sqlSessionFactory --》 sqlSession
public class MybatisUtils {

    private static SqlSessionFactory sqlSessionFactory;

    static {
        try {
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // !既然有了SqlSessionFactory，我们就可以从中获得SqlSession的实例了
    // !SqlSession完全包含了面向数据库执行SQL命令的所有方法

    public static SqlSession getSqlSession() {
        return sqlSessionFactory.openSession();
    }

}
