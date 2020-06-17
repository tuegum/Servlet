package tuegum.web.servlet;


import org.apache.commons.beanutils.BeanUtils;
import tuegum.dao.UserDao;
import tuegum.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.Set;


@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       //1.设置编码
        req.setCharacterEncoding("utf-8");

       /*//2.获取参数
        String name = req.getParameter("username");
        String password = req.getParameter("password");

        //3.封装User对象
        User loginUser = new User();
        loginUser.setName(name);
        loginUser.setPassword(password);*/

        // 2.获取所有请求参数
        Map<String, String[]> map = req.getParameterMap();

        //3.创建User对象
        User loginUser = new User();

        //3.2使用BeanTools封装
        try {
            BeanUtils.populate(loginUser,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        //4.调用UserDao的login方法
        UserDao dao = new UserDao();
        User user = dao.login(loginUser);

        //输出所有请求参数的map集合
        System.out.println("输出所有请求参数的map集合");
        Set<String> strings = map.keySet();
        for (String string : strings) {
            String[] values = map.get(string);
            System.out.println(string);
            for (String value : values) {
                System.out.println(value);
            }
            System.out.println("=====分隔符====");
        }

        if (user == null){
            //登录失败
            System.out.println("登录失败");
            req.getRequestDispatcher("/failedServlet").forward(req,resp);
        }else {
            //登录成功
            //存储数据
            System.out.println("登录成功");
            req.setAttribute("user",user);
            //转发
            req.getRequestDispatcher("/successServlet").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
