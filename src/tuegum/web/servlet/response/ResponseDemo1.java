package tuegum.web.servlet.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 重定向
 */

@WebServlet("/responseDemo1")
public class ResponseDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //访问/responseDemo1， 会自动跳转到/responseDemo2资源

        System.out.println("responseDemo1被访问了");
//        //1.设置状态码为302
//        response.setStatus(302);
//        //2.设置响应头location
//        response.setHeader("location","http://localhost/naruto/responseDemo2");

        request.setAttribute("msg","response");

        //动态获取虚拟目录，不能把虚拟目录给写死了
        String contextPath = request.getContextPath();
        System.out.println(contextPath);
        //简化设置重定向，需要添加虚拟目录
        response.sendRedirect(contextPath + "/responseDemo2");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
