import com.zhaomeng.config.ZhaomengConfig;
import com.zhaomeng.pojo.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author: zhaomeng
 * @Date: 2022/10/26 18:46
 */
public class MyTest {
    public static void main(String[] args) {
        // !如果完全使用了配置类方式去做，我们就只能通过AnnotationConfig上下文来获取上下文来加载容器
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ZhaomengConfig.class);

        User getUser = context.getBean("getUser", User.class);
        System.out.println(getUser.getName());
    }
}
