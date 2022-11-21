package com.zhaomeng;

import org.apache.log4j.Logger;

/**
 * @author: zhaomeng
 * @Date: 2022/9/4 22:14
 */
public class Log4j08 {

    public static void main(String[] args) {
        /**
         * 自定义logger
         *
         * 如果根节点的logger和自定义logger配置的输出文职是不同的，则取二者的并集，配置的位置都会进行输出操作
         * 如果二者配置的日志级别不同，则按照自定义logger的级别来
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
