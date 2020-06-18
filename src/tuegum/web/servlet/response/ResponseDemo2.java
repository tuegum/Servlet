package tuegum.web.servlet.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/responseDemo2")
public class ResponseDemo2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("responseDemo2被访问了");

        //重定向无法使用request对象共享数据，以下输出为null
        Object msg = request.getAttribute("msg");
        System.out.println(msg);

        //重定向到https://www.baidu.com,redirect可以访问其他服务器资源，forward只能访问本服务器资源
//        response.sendRedirect("https://www.baidu.com");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
