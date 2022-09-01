package com.zhaomeng;

import java.io.IOException;
import java.util.logging.*;

/**
 * @author zhaomeng
 * @date 2022/8/29 0029 23:53
 */
public class JulStudy04 {

    public static void main(String[] args) throws IOException {
        /**
         * 将日志输出到磁盘文件中
         * 相当于做了日志的持久化操作
         */

        Logger logger = Logger.getLogger("com.zhaomeng.JulStudy04");
        logger.setUseParentHandlers(false);

        // !文件日志处理器
        FileHandler fileHandler = new FileHandler("E:\\Code\\tmp\\test.log");
        SimpleFormatter formatter = new SimpleFormatter();
        fileHandler.setFormatter(formatter);
        logger.addHandler(fileHandler);

        // !也可以同时在控制台和文件中进行打印
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setFormatter(formatter);
        // !一个logger记录器中可以添加多个日志执行器handler
        logger.addHandler(consoleHandler);

        logger.setLevel(Level.ALL);
        fileHandler.setLevel(Level.ALL);
        // !consoleHandler没有设置日志级别，默认打印info级别

        logger.info("info信息");
        logger.severe("severe信息");
        logger.warning("warning信息");
        logger.config("config信息");
        logger.fine("fine信息");
        logger.finer("finer信息");
        logger.finest("finest信息");

        /**
         * 总结：
         * 用户使用Logger来进行日志的记录，Logger可以持有多个处理器handler
         * 日志记录使用的是logger，日志输出使用的是handler
         * 添加了哪些handler对象，就相当于需要根据所添加的handler
         * 将日志输出到指定的位置上，例如控制台，文件
         */
    }
}
