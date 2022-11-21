package com.zhaomeng;

import org.apache.log4j.Logger;

/**
 * @author: zhaomeng
 * @Date: 2022/9/4 22:21
 */
public class Log4j09 {

    public static void main(String[] args) {
        /**
         * 自定义logger的应用场景
         * 我们之所以要自定义logger，就是为了针对不同的系统信息做更灵活的输出操作
         * 例如：
         * 我们可以在原有的案例基础之上，加上一个apache的日志输出
         * log4j.logger.org.apache=error.console
         *
         * 现在配置文件中有三项
         * log4j.rootLogger=info,console
         * log4j.logger.com.zhaomeng=trace,file
         * log4j.logger.org.apache=error.console
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
