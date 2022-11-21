package com.zhaomeng;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author: zhaomeng
 * @Date: 2022/9/5 23:23
 */
public class SLF4J01 {

    public static void main(String[] args) {
        /**
         * 入门案例
         *
         * slf4j读日志的级别划分
         * trace：日志追踪信息
         * debug：日志详细信息
         * info：日志关键信息       默认的日志输出级别
         * warn：日志警告信息
         * error：日志错误信息
         *
         * 在没有任其他日志实现框架集成的基础之上
         * slf4j使用的就是自带的框架slf4j-simple
         * simple-simple也必须以单独的依赖的形式引入进来
         */

        Logger logger = LoggerFactory.getLogger(SLF4J01.class);

        logger.trace("trace信息");
        logger.debug("debug信息");
        logger.info("info信息");
        logger.warn("warn信息");
        logger.error("error信息");
    }
}
