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
@WebServlet("/cookieDemo3")
public class CookieDemo3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.设置response编码
        response.setContentType("text/html;charset=UTF-8");
        //2.创建cookie对象
        Cookie cookie2 = new Cookie("ABadGuy","拉格朗日");
        //3.设置cookie存活时间
        cookie2.setMaxAge(100);
        //4.向浏览器发送cookie
        response.addCookie(cookie2);
        response.getWriter().write("我已经向浏览器写了两个个cookie");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
