package tuegum.util;

import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;
import tuegum.domain.User;

import java.lang.reflect.InvocationTargetException;

public class BeanUtilsTest {
    /**
     * BeanUtils 的 setproperty() getproperty()方法测试
     * 属性和成员变量测试
     *      设置gender（成员变量）无效，设置hehe(属性)成功
     */
    @Test
    public void test(){
        User user = new User();
        try {
            BeanUtils.setProperty(user,"hehe","male");
            String gender = BeanUtils.getProperty(user, "hehe");
            System.out.println(gender);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        System.out.println(user);
    }
}
