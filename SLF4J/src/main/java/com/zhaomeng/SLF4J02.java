package com.zhaomeng;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author: zhaomeng
 * @Date: 2022/9/5 23:32
 */
public class SLF4J02 {

    public static void main(String[] args) {
        /**
         * 我们输出动态的日志信息的时候
         * 也可以使用占位符的形式来代替字符串的拼接
         *
         * 我们有时候输出的日志信息，需要我们搭配动态的诗句
         * 有可能是信息，有可能是数据库中的数据
         *
         * 终止我们这样的最大好处就是能够让日志打印变的更加灵活
         * 我们的日志打印是支持以替代符的形式做日志信息拼接的
         * 一般情况下，几乎所有的日志实现产品，都会提供这种功能
         */

        Logger logger = LoggerFactory.getLogger(SLF4J01.class);

        String name = "zs";
        int age = 23;
        logger.info("姓名：{}，年龄：{}", name, age);

        try {
            Class.forName("aaa");
        } catch (ClassNotFoundException e) {
            // !打印堆栈信息
//            e.printStackTrace();
            logger.info("xxx类中的xxx方法出现了异常，请及时关注");
            logger.info("具体错误是：", e);
        }
    }
}
