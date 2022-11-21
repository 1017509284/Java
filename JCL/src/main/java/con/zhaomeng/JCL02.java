package con.zhaomeng;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author: zhaomeng
 * @Date: 2022/9/4 22:46
 */
public class JCL02 {

    public static void main(String[] args) {

        /**
         *
         * 导入log4j依赖，继续测试原有程序
         * 总结：
         * 我们上一个案例，使用的是JUL，但是在集成了log4j环境后，使用的又是log4j
         * 通过测试观察，虽然日志框架发生了变化，但是代码完全没有改变
         *
         * 日志门面技术的好处：
         * 门面技术是面向解救的开发，不再依赖具体的实现，减少代码的耦合性
         * 可以根据实际需求，灵活的切换日志框架
         * 统一的aPI，方便开发者学习和使用
         * 统一的配置管理便于项目日志的维护工作
         *
         * 查看源码：
         * Log接口的4个实现类
         * JDK13
         * JDK14：正常java.util.logging （JUL）
         * Log4j：我们集成的log4j
         * Simple：JCL自带的实现类
         *
         */

        /**
         * 观察LogFactory，看看如何加载Logger对象
         * 这是一个抽象类，无法实例化
         * 需要观察LogFactoryImpl
         * 进入到getInstance方法
         * 找到instance = this.newInstance(name);继续进入
         * 找到instance = this.discoverLogImplementation(name);表示发现一个日志的实现
         *
         * for (int i = 0; i < classesToDiscover.length && result == null; i++) {
         *     result = this.createLogFromClass(classToDiscover[i], logCategory, true);
         * }
         * 遍历我们拥有的日志实现框架，遍历的是一个数组，遍历顺序为
         * log4j, jdk14, jdk13, Simple
         * 第一个遍历的是log4j，如果有，则执行该框架，如果没有再寻找jdk14
         */
        Log log = LogFactory.getLog(JCL02.class);
        log.info("info信息");
    }
}
