package com.zhaomeng;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * @author zhaomeng
 * @date 2022/8/29 0029 23:40
 */
public class JulStudy03 {

    public static void main(String[] args) {

        /**
         * !自定义日志级别
         */
        // !获取日志记录器
        Logger logger = Logger.getLogger("com.zhaomeng.JulStudy03");

        // !将默认的日志打印方式关闭掉
        // !参数设置为fasle，我们打印的日志的方式就不会按照父logger默认的方式去进行操作
        logger.setUseParentHandlers(false);

        // !处理器handler，我们是用控制台日志处理器，取得对象
        ConsoleHandler consoleHandler = new ConsoleHandler();

        // !创建日志格式化组件对象
        SimpleFormatter formatter = new SimpleFormatter();

        // !在处理器中设置输出格式
        consoleHandler.setFormatter(formatter);

        // !在记录器中添加处理器
        logger.addHandler(consoleHandler);

        // !设置日志的打印级别，此处必须讲日志记录器和处理器的级别进行统一的设置
        // !才会达到日志显示相应级别的效果
        logger.setLevel(Level.CONFIG);
        consoleHandler.setLevel(Level.CONFIG);

        /**
         * logger.setLevel(Level.ALL);
         * consoleHandler.setLevel(Level.ALL);
         */

        // !现在进行日志输出，并观察输出结果
        logger.info("info信息");
        logger.severe("severe信息");
        logger.warning("warning信息");
        logger.config("config信息");
        logger.fine("fine信息");
        logger.finer("finer信息");
        logger.finest("finest信息");
    }
}
