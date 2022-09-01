package com.zhaomeng;


import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author zhaomeng
 * @date 2022/8/29 0029 23:20
 */
public class JulStudy02 {

    public static void main(String[] args) {
        /**
         * SEVERE：（最高级）错误
         * WARNING：警告
         * INFO：（默认级别）消息
         * CONFIG：配置
         * FINE：详细信息
         * FINER：详细信息
         * FINEST：详细级别（最低级）
         *
         * OFF：可用来关闭日志记录
         * ALL：启用所有日志的记录
         *
         * 对于日志级别，我们重点关注的是new对象的时候的第二个参数，也就是一个数值
         *
         * OFF      Integer.MAX_VALUE
         * SEVERE   1000
         * WARNING  900
         * .......
         * FINEST   300
         *
         * ALL      Integer.MIN_VALUE
         *
         * 这个数值的意义在于，如果我们设置的日志级别是INFO--800，那么最终展示的日志信息，必须是
         * 大于800的所有日志信息，最终展现的就是SEVERE WARNING INFO
         */
        Logger logger = Logger.getLogger("com.zhaomeng.JulStudy02");

        // 观察打印结果可以看到，仅仅输出了info severe warning级别的日志，可以证明info级别是系统默认日志级别
        // 如果仅仅只是通过以下形式来设置日志级别，那么不能够起到作用，需要搭配handler才会生效
        logger.setLevel(Level.CONFIG);

        logger.info("info信息");
        logger.severe("severe信息");
        logger.warning("warning信息");
        logger.config("config信息");
        logger.fine("fine信息");
        logger.finer("finer信息");
        logger.finest("finest信息");
    }
}
