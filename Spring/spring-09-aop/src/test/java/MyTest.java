import com.zhaomeng.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: zhaomeng
 * @Date: 2022/10/27 23:22
 */
public class MyTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // !动态代理 代理的是接口
        UserService userService = (UserService) context.getBean("userService");
        userService.add();
    }
}
