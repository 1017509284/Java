package com.zhaomeng;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author: zhaomeng
 * @Date: 2022/9/7 23:10
 */
public class Log4j202 {

    public static void main(String[] args) {

        /**
         * 使用配置文件
         * log4j2是参看logback创作出来的，所以配置文件也是使用xml
         * log4j2同样是默认加载类路径（resources）下的log4j2.xml文件中的配置
         *
         * 根标签，所有日志相关信息，都是在根标签中进行配置
         * <Configuration></Configuration>
         *
         * 在根标签中可以加属性
         * <Configuration status="debug"></Configuration>
         * status="debug"表示日志框架本身的日志输出级别
         */

        Logger logger = LogManager.getLogger(Log4j202.class);

        logger.fatal("fatal信息");
        logger.error("error信息");
        logger.warn("warn信息");
        logger.info("info信息");
        logger.debug("debug信息");
        logger.trace("trace信息");
    }
}
