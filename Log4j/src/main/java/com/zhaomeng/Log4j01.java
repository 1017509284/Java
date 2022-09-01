package com.zhaomeng;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

/**
 * @author: zhaomeng
 * @Date: 2022/8/30 23:39
 */
public class Log4j01 {

    public static void main(String[] args) {
        // !Log4j入门案例
        // !加载初始化配置
        // !Logger root = Logger.getRootLogger();
        // !root.addAppender(new ConsoleAppender(new PatternLayout("%r [%t] %p %c %x - %m%n")));
        // !此配置定义了rootLogger，并在rootLogger中添加了控制台处理器
        /**
         * ALL：最低等级，用于打开所有级别的日志记录
         * TRACE：程序推进下的追踪信息，这个追踪信息的日志级别非常低，一般情况下是不会用到的
         * DEBUG：支出细粒度信息时间对调试应用程序是非常有帮助的，主要是配合开发，在开发过程中打印一些重要的运行信息
         * INFO：消息的粗粒度级别运行信息
         * WARN：警告，程序可能出现的隐形的错误
         * ERROR：系统的错误信息，发生的错误不影响系统的运行，一般情况下，不想输出太多的日志，则使用该级别即可
         * FATAL：表示严重错误，一旦发生系统就不可能继续运行了
         * OFF：最高等级，表示关闭所有的日志记录
         */
        BasicConfigurator.configure();

        Logger logger = Logger.getLogger(Log4j01.class);

        // !debug使我们没有设置日志级别的情况下，默认的日志级别
        logger.fatal("fatal信息");
        logger.error("error信息");
        logger.warn("warn信息");
        logger.info("info信息");
        logger.debug("debug信息");
        logger.trace("trace信息");
    }
}
