package tuegum.web.request;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 演示request对象获取请求头数据中的 referer
 * */
@WebServlet("/RequestDemo04")
public class RequestDemo04 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //演示获取请求头数据：user-agent
        String referer = request.getHeader("referer");
        System.out.println(referer);

        //防盗链
        if (referer != null){
            if (referer.contains("/tuegum1")){
                System.out.println("1111");
            }else{
                System.out.println("2222222");
            }
        }

        ServletConfig servletConfig = this.getServletConfig();
        String value = servletConfig.getInitParameter("name");
        System.out.println(value);
    }
}
