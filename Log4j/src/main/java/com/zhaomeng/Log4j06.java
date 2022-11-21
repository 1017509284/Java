package com.zhaomeng;

import org.apache.log4j.Logger;

/**
 * @author: zhaomeng
 * @Date: 2022/9/2 22:53
 */
public class Log4j06 {

    public static void main(String[] args) {
        /**
         * 将日志输出到文件上
         * 日志太多了，不方便管理
         * FileAppender为我们提供了好用的子类来进一步的对于文件输出进行管理
         * RollingFileAppender
         * DailyRollingFileAppender
         *
         * 1. 先来学习RollingFileAppender
         * 这个类表示使用按照文件大小进行拆分的方式进行操作
         *
         * 2. DailyRollingFileAppender按照时间来进行文件的划分
         * private String datePattern = "'.'yyyy-MM-dd";默认是按照天来进行拆分的
         */

        Logger logger = Logger.getLogger("com.zhaomeng.Log4j03");

        for (int i = 0; i < 10000; i++) {
            logger.fatal("fatal信息");
            logger.error("error信息");
            logger.warn("warn信息");
            logger.info("info信息");
            logger.debug("debug信息");
            logger.trace("trace信息");
        }

    }
}
