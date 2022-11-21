package com.zhaomeng;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author: zhaomeng
 * @Date: 2022/9/7 23:05
 */
public class Log4j201 {

    public static void main(String[] args) {

        /**
         * 单纯的使用Log4j2的门面+实现
         * Log4j2和Log4j提供了相同的日志界别输出
         * 默认为error级别的打印
         *
         * ERROR StatusLogger No Log4j 2 configuration file found. Using default configuration (logging only errors to the console),
         * 表示我们还没有创建自己的配置文件
         * 如果没有建立配置文件，则使用默认的配置
         */

        Logger logger = LogManager.getLogger(Log4j201.class);

        logger.fatal("fatal信息");
        logger.error("error信息");
        logger.warn("warn信息");
        logger.info("info信息");
        logger.debug("debug信息");
        logger.trace("trace信息");
    }
}
