package com.zhaomeng;

import org.apache.log4j.Logger;
import org.apache.log4j.helpers.LogLog;

/**
 * @author: zhaomeng
 * @Date: 2022/8/31 23:49
 */
public class Log4j03 {

    public static void main(String[] args) {

        /**
         * 通过Logger中的开关，打开日志输出的详细信息，查看LogManager类中的方法getLoggerRepository()
         * 找到代码LogLog.debug(msg, ex);
         * LogLog会使用debug级别的输出为我们展现日志输出详细信息
         * Logger是记录系统的日志，那么LogLog是用来记录Logger的日志
         *
         * 进入到LogLog.debug(msg, ex)方法中
         * 通过观察代码if (debugEnabled && !quietMode)
         * 观察到if判断中的两个开关都必须开启才行
         * !quietMode默认是开启的，debugEnabled默认是关闭的
         * 所以我们只需要设置debugEnabled为true就可以了
         */

        // !打开LogLog日志输出的开关，可以看到记录Logger的日志
        LogLog.setInternalDebugging(true);
        Logger logger = Logger.getLogger("com.zhaomeng.Log4j03");

        logger.fatal("fatal信息");
        logger.error("error信息");
        logger.warn("warn信息");
        logger.info("info信息");
        logger.debug("debug信息");
        logger.trace("trace信息");
    }
}
