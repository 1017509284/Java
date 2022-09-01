import com.zhaomeng.dao.UserDaoImpl;
import com.zhaomeng.dao.UserDaoMysqlImpl;
import com.zhaomeng.dao.UserDaoOracleImpl;
import com.zhaomeng.service.UserServiceImpl;

/**
 * @author: zhaomeng
 * @Date: 2022/5/17 23:38
 */
public class MyTest {
    public static void main(String[] args) {
        //! 用户实际调用service层， dao层它们不需要care
//        UserServiceImpl userService = new UserServiceImpl();
//        userService.getUser();


        UserServiceImpl userService = new UserServiceImpl();
        userService.setUserDao(new UserDaoImpl());
        userService.getUser();

        userService.setUserDao(new UserDaoMysqlImpl());
        userService.getUser();

        userService.setUserDao(new UserDaoOracleImpl());
        userService.getUser();
    }
}
