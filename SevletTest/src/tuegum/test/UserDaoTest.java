package tuegum.test;

import org.junit.Test;
import tuegum.dao.UserDao;
import tuegum.domain.User;

public class UserDaoTest {

    @Test
    public void testLogin(){
        User loginuser = new User();
        loginuser.setName("lisi");
        loginuser.setPassword("234567");

        UserDao dao = new UserDao();
        User user = dao.login(loginuser);
        System.out.println(user);
    }
}
