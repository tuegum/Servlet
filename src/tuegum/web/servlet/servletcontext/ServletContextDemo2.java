package tuegum.web.servlet.servletcontext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ServletContext功能
 * 获取MINE类型
 */
@WebServlet("/servletContextDemo2")
public class ServletContextDemo2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取ServletContext对象
        ServletContext context = this.getServletContext();

        //2.定义文件名称
        String f = "a.jpg";

        //3.获取MIME类型
        String mimeType = context.getMimeType(f);
        System.out.println("11111111");
        System.out.println(mimeType);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
