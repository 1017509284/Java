import com.zhaomeng.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: zhaomeng
 * @Date: 2022/5/18 01:33
 */
public class MyTest {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        //! 此处调用的是默认的无参构造
        //! 如果没有默认的无参构造则会报错
        //! 此处虽然没有get userT，但是userT也会调用构造函数进行创建并放到容器中
        User user = (User) context.getBean("user");
        User user1 = (User) context.getBean("user");

        //! 内存中就只有一份实例，所以对user的多次get得到的对象是一样的
        System.out.println(user == user1);

        user.show();
    }
}
