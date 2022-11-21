package con.zhaomeng;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author: zhaomeng
 * @Date: 2022/9/4 22:37
 */
public class JCL01 {
    public static void main(String[] args) {
        /**
         *
         * 暂时先不导入第三方日志框架， 例如log4j
         * 默认情况下，会使用JUL日志框架做日志的记录
         *
         * JCL使用远侧：
         * 如果有log4j，优先使用log4j
         * 如果没有任何第三方日志框架的时候，就是用JUL
         */
        Log log = LogFactory.getLog(JCL01.class);
        log.info("info信息");
    }
}
