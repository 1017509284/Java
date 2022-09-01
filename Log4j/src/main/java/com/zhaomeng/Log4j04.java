package com.zhaomeng;

import org.apache.log4j.Logger;

/**
 * @author: zhaomeng
 * @Date: 2022/9/1 23:20
 */
public class Log4j04 {

    public static void main(String[] args) {
        /**
         * 关于log4j.properties layout属性的配置
         * 其中PatternLayout是日常使用最多的方式
         * 查看其源码
         * setConversionPattern这个方法就是该PatternLayout的和新方法
         * conversionPattern
         *
         * 在log4j.properties中将layout设置为PatternLayout
         * 我们主要配置的是conversionPattern属性
         */

        Logger logger = Logger.getLogger("com.zhaomeng.Log4j03");

        logger.fatal("fatal信息");
        logger.error("error信息");
        logger.warn("warn信息");
        logger.info("info信息");
        logger.debug("debug信息");
        logger.trace("trace信息");
    }
}
