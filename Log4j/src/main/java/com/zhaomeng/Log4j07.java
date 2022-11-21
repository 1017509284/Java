package com.zhaomeng;

import org.apache.log4j.Logger;

/**
 * @author: zhaomeng
 * @Date: 2022/9/4 21:25
 */
public class Log4j07 {

    public static void main(String[] args) {
        /**
         * 将日志输出到数据库当中
         *
         * CREATE TABLE tbl_log(
         * 	id INT(11) not null AUTO_INCREMENT,
         * 	name VARCHAR(255) DEFAULT NULL COMMENT '项目名称',
         * 	createTime VARCHAR(255) DEFAULT NULL COMMENT '创建时间',
         * 	level VARCHAR(255) DEFAULT NULL COMMENT '日志级别',
         * 	category VARCHAR(255) DEFAULT NULL COMMENT '所在类的全路径',
         * 	fileName VARCHAR(255) DEFAULT NULL COMMENT '文件名称',
         * 	message VARCHAR(255) DEFAULT NULL COMMENT '日志消息',
         * 	PRIMARY KEY(id)
         * 	);
         *
         *
         *
         #输出到db中的appender
         log4j.appender.logDB=org.apache.log4j.jdbc.JDBCAppender
         log4j.appender.logDB.layout=org.apache.log4j.PatternLayout
         log4j.appender.logDB.Driver=com.mysql.jdbc.Driver
         log4j.appender.logDB.URL=jdbc:mysql://localhost:3306/log4j
         log4j.appender.logDB.User=root
         log4j.appender.logDB.Password=zhaomeng
         log4j.appender.logDB.Sql=INSERT INTO tbl_log(name,createTime,level,category,fileName,message) value('project_log','%d{yyyy-MM-dd HH:mm:ss}','%p','%c','%F','%m')
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
