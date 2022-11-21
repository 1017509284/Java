package com.zhaomeng;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author: zhaomeng
 * @Date: 2022/9/7 23:52
 */
public class Log4j204 {

    public static void main(String[] args) {

        Logger logger = LoggerFactory.getLogger(Log4j203.class);

        logger.error("error信息");
        logger.warn("warn信息");
        logger.info("info信息");
        logger.debug("debug信息");
        logger.trace("trace信息");
    }
}
