package com.zhaomeng;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author zhaomeng
 * @date 2022/8/28 0028 23:47
 */
public class JulStudy01 {
    public static void main(String[] args) {
        // 创建一个logger对象，不能用new方法
        // 取的对象的方法参数，需要引入当前类的全路径
        // 日志的入口程序 java.util.logging.Logger
        Logger logger = Logger.getLogger("com.zhaomeng.JulStudy");

        // 日志输出
        // 1.输出info级别的日志
        logger.info("输出info信息1");

        // 2.通过调用log方法，在里面通过level类型来定义日志的级别参数
        logger.log(Level.INFO, "输出info信息2");

        // 3.输出学生信息 姓名，年龄
        String name = "zhangsan";
        int age = 23;
        logger.log(Level.INFO, "学生的姓名为：" + name + "学生的年龄为：" + age);

        // 对于输出日志，字符串的拼接弊端很多
        // 麻烦，程序效率低，可读性不强，维护成本高
        // 应该使用动态生成数据的方式来生产日志
        // 使用占位符的方式来操作

        logger.log(Level.INFO, "学生的姓名为：{0}，年龄：{1}", new Object[]{name, age});
    }
}
