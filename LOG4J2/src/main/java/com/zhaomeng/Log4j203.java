package com.zhaomeng;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author: zhaomeng
 * @Date: 2022/9/7 23:34
 */
public class Log4j203 {

    public static void main(String[] args) {

        /**
         * 虽然log4j2也是日志门面，但是现在市场的主流趋势仍然是slf4j
         * 所以我们仍然需要使用slf4j作为日志门面，搭配log4j强大的日志实现功能，进行日志的相关操作
         * slf4j + log4j2
         *
         * 1. 导入slf4j的日志门面
         * 2. 导入log4j2的适配器
         * 3. 导入log4j2的日志门面
         * 4. 导入log4j2的日志实现
         *
         * 执行原理：slf4j门面调用的是log4j的门面，再由log4j2的门面调用log4j2的实现
         */

        // !此次的Logger使用的是org.slf4j的Logger，不是org.apache.logging.log4j.Logger;
        Logger logger = LoggerFactory.getLogger(Log4j203.class);

        logger.error("error信息");
        logger.warn("warn信息");
        logger.info("info信息");
        logger.debug("debug信息");
        logger.trace("trace信息");
    }
}
