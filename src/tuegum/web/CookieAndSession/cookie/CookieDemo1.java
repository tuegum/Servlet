package tuegum.web.CookieAndSession.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * cookie的快速入门
 */
@WebServlet("/cookieDemo1")
public class CookieDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.设置response编码
        response.setContentType("text/html;charset=UTF-8");

        //2.创建cookie对象
        Cookie cookie1 = new Cookie("username", "tuegum");
        Cookie cookie2 = new Cookie("math", URLEncoder.encode("拉格朗日", "UTF-8"));

        //3。设置path,让当前服务器下的部署的所有的项目共享cookie1信息
        cookie1.setPath("/");

        //4.设置cookie存活时间
        cookie1.setMaxAge(2000);
        cookie2.setMaxAge(100);

        //5.向浏览器发送cookie
        response.addCookie(cookie1);
        response.addCookie(cookie2);
        response.getWriter().write("我已经向浏览器写了两个个cookie");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
