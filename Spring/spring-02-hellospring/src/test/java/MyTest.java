import com.zhaomeng.Hello;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: zhaomeng
 * @Date: 2022/5/18 01:09
 */
public class MyTest {
    public static void main(String[] args) {
        //! 获取spring的上下文对象
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        //! 对象现在都在spring中进行管理了，要使用的话，直接去取出来
        Hello hello = (Hello) context.getBean("hello");

        System.out.println(hello.toString());

    }
}
