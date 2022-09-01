package com.zhaomeng;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

/**
 * @author: zhaomeng
 * @Date: 2022/8/31 23:15
 */
public class Log4j02 {

    public static void main(String[] args) {
        // !观察源码BasicConfigurator.configure();
        // !可以得到2条信息
        // !（1）创建了根节点Logger root = Logger.getRootLogger();
        // !（2）根节点添加了ConsoleAppender对象，（表示默认打印到控制台，自定义格式化输出）new ConsoleAppender


        // !我们这次不使用BasicConfigurator.configure();，使用自定义的配置文件来实现功能
        // !通过我们对于以上第一点的分析
        // !我们的配置文件需要提供Logger、Appender、Layout这三个组件的信息（通过配置来代替以上的代码）
        /**
         * 分析：
         * Logger logger = Logger.getLogger(Log4j01.class);
         * 进入到getLogger方法，会看到代码return LogManager.getLogger(clazz.getName());
         * LogManage：日志管理器
         *
         * 点击LogManage，看看这个日志管理器中实现了什么
         * 可以看到很多常量信息，它们代表的就是不同形式（后缀名不同）的配置文件
         * 我们最常使用的肯定是log4j.properties属性文件（语法简单，使用方便）
         */

        /**
         * 问题：log4j.properties的加载时机
         * 继续观察LogManager，找到其中的静态代码块static
         * 在static代码块中，我们找到Loader.getResource("log4j.properties");
         * 这行代码给我们最大的提示信息就是系统默认要从当前的类路径下找到log4j.properties
         * 对于我们当前的项目是maven项目，那么李颖在resources路径下去找
         *
         * 加载完之后是怎么读取配置文件的呢
         * 继续观察LogManager，找到OptionConverter.selectAndConfigure(url, configuratorClassName, getLoggerRepository());
         * 作为属性文件的加载，执行相应的properties配置对象，configurator = new PropertyConfigurator();
         *
         * 进入到PropertyConfigurator类中，观察到里面的常量信息
         * 这些常量信息就是我们在properties属性文件中各种属性配置项
         * 其中，我们看到了如下两项信息，这两项信息是必须要进行配置的
         *
         *    static final String ROOT_LOGGER_PREFIX = "log4j.rootLogger";
         *    static final String APPENDER_PREFIX = "log4j.appender.";
         */
        // !注释掉，执行我们自定义配置的日志配置文件
        // BasicConfigurator.configure();

        Logger logger = Logger.getLogger(Log4j01.class);

        // !debug是我们没有设置日志级别的情况下，默认的日志级别
        logger.fatal("fatal信息");
        logger.error("error信息");
        logger.warn("warn信息");
        logger.info("info信息");
        logger.debug("debug信息");
        logger.trace("trace信息");
    }
}
