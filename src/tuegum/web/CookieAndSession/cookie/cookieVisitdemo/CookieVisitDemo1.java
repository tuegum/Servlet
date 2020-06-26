package tuegum.web.CookieAndSession.cookie.cookieVisitdemo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/cookieVisitDemo01")
public class CookieVisitDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        Cookie[] cookies = request.getCookies();
        boolean flag = false;
        if (cookies != null && cookies.length > 0){
            for (Cookie cookie : cookies) {
                String name = cookie.getName();
                if ("last_time".equals(name)){
                    flag = true;
                    String value = cookie.getValue();
                    value = URLDecoder.decode(value,"utf-8");
//                    response.reset();
                    response.getWriter().write("<h1>欢迎回来，您上次的访问时间为：" + value + "</h1>");

                    Date date = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
                    String sdf_date = sdf.format(date);
                    System.out.println("编码前：" + sdf_date);
                    //URL编码
                    sdf_date = URLEncoder.encode(sdf_date,"utf-8");
                    System.out.println("编码后：" + sdf_date);
                    cookie.setValue(sdf_date);
                    cookie.setMaxAge(60*60*24*30);
                    response.addCookie(cookie);
                    break;
                }
            }
        }
        if (cookies != null || cookies.length == 0 || flag == false){
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
            String sdf_date = sdf.format(date);
            sdf_date = URLEncoder.encode(sdf_date,"utf-8");
            Cookie cookie = new Cookie("last_time", sdf_date);
            cookie.setMaxAge(60*60*24*30);
            response.addCookie(cookie);

            response.getWriter().write("<h1>您好，欢迎您首次登录</h1>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }


}
