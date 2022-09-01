package com.zhaomeng;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * @author zhaomeng
 * @date 2022/8/30 0030 0:07
 */
public class JulStudy05 {

    public static void main(String[] args) {
        /**
         * Logger之间的父子关系
         * JUL中Logger之间是存在“父子”关系的
         * 值得注意的是，这种父子关系不是我们普遍认为的类之间的继承关系
         * 关系是通过树状结构存储的
         *
         * JUL在初始化时会创建一个顶层RootLogger作为所有Logger的父Logger
         * 查看源码：owner.rootLogger = owner.new RootLogger();
         * RootLogger是LogManager的内部类
         * 默认的名称为空串
         *
         * 以上的RootLogger对象作为树状结构的根节点存在的
         * 将在的自定义的父子关系通过路径来进行关联
         * 父子关系，同时也是节点之间的挂载关系
         * owner.addLogger(owner.rootLogger);
         * LoggerContext cx = getUserContext(); // LoggerContext是一种用来保存节点的Map关系
         */

        // !可以认为logger1 是 logger2的父亲
        Logger logger1 = Logger.getLogger("com.zhaomeng");
        Logger logger2 = Logger.getLogger("com.zhaomeng.JulStudy05");

        // !可以看到会打印true
        System.out.println(logger2.getParent() == logger1);

        // !可以看到logger2的父亲为logger1
        // !logger1的父亲为LogManager@RootLogger，父亲的名称为一个空字符串
        // !RootLogger可以被称为所有logger对象的顶层logger
        System.out.println("logger1的父logger为：" + logger1.getParent()
        + ";名称为:" + logger1.getName() +"; 父亲的名称为" + logger1.getParent().getName());

        System.out.println("logger2的父logger为：" + logger2.getParent()
                + ";名称为:" + logger2.getName() +"; 父亲的名称为" + logger2.getParent().getName());

        /**
         * 父亲所做的设置，也能够同时作用在儿子上
         * 对logger1所做的日志打印相关的设置，然后我们使用logger2进行日志的打印
         */

        // !父亲做设置
        logger1.setUseParentHandlers(false);
        ConsoleHandler consoleHandler = new ConsoleHandler();
        SimpleFormatter formatter = new SimpleFormatter();
        consoleHandler.setFormatter(formatter);
        logger1.addHandler(consoleHandler);
        consoleHandler.setLevel(Level.ALL);
        logger1.setLevel(Level.ALL);

        // !儿子做打印
        logger2.info("info信息");
        logger2.severe("severe信息");
        logger2.warning("warning信息");
        logger2.config("config信息");
        logger2.fine("fine信息");
        logger2.finer("finer信息");
        logger2.finest("finest信息");
    }
}
