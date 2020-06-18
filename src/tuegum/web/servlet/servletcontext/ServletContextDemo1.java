package tuegum.web.servlet.servletcontext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 获取ServletContext对象
 */
@WebServlet("/servletContextDemo1")
public class ServletContextDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取ServletContext对象
        //1.1通过request获取
        ServletContext context1 = request.getServletContext();
        //1.2通过HttpServlet获取
        ServletContext context2 = this.getServletContext();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
