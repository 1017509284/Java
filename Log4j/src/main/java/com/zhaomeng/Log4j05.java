package com.zhaomeng;

import org.apache.log4j.Logger;

/**
 * @author: zhaomeng
 * @Date: 2022/9/1 23:45
 */
public class Log4j05 {

    public static void main(String[] args) {
        // !将日志信息输出到文件中

        Logger logger = Logger.getLogger("com.zhaomeng.Log4j03");

        logger.fatal("fatal信息");
        logger.error("error信息");
        logger.warn("warn信息");
        logger.info("info信息");
        logger.debug("debug信息");
        logger.trace("trace信息");
    }
}
