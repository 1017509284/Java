package com.zhaomeng;

/**
 * @author: zhaomeng
 * @Date: 2022/9/6 00:00
 */
public class SLF4J03 {

    public static void main(String[] args) {

        /**
         * 集成其他日志实现之前，观察官网的架构图
         *
         * SLF4J日志门面，共有3种情况对日志实现进行绑定
         * 1. 在没有绑定任何日志实现的基础之上，日志是不能够绑定实现任何功能的
         * 值得注意的是，通过我们刚刚演示，slf4j-simple是slf4j官方提供的，使用的时候
         * 也是需要导入依赖的，从而自动的绑定的slf4j门面上
         * 如果不导入，slf4j核心依赖是不提供任何事先的
         *
         * 2. logback和simple（包括nop）
         * 都是slf4j门面时间线后面提供的日志实现，所以api完全遵循slf4j进行的设计
         * 那么我们只需要导入想要使用的日志实现依赖，即可与slf4j无缝衔接
         * 值得一提的是是nop虽然也划分到实现中了，但是它是指不识闲日志记录
         *
         * 3. log4j和JUL
         * 都是slf4j门面时间线前面的日志实现，所以API不遵循slf4j进行设计
         * 通过适配器桥接的技术，完成的与日志门面的衔接
         *
         * SLF4J：Class path contains multiple SLF4J bindings
         * 出现如上提示证明：在slf4j环境下，同时出现了多个日志的实现
         * 如果先导入logback依赖，后导入slf4j-simple依赖
         * 那么默认使用的就是logback
         *
         * 结论：如果有多个日志实现的话，默认使用先行导入的
         */
    }
}
