package tuegum.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 演示request对象获取请求行数据
 * */
@WebServlet("/RequestDemo01")
public class RequestDemo01 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
        1.  获取请求方式 ：GET
            *	String getMethod()
        2.  获取虚拟目录：/我这里设为空
            *	String getContextPath()
        3.  获取Servlet路径： /demo3
            *	String getServletPath()
        4.  获取get方式请求参数：username=3516697
            * 	String getQueryString()
        5.  获取请求URI ：/虚拟目录/demo3(虚拟目录我设为空)
            *	String getRequestURI()； /demo3
            *	StringBuffer getRequestURL()；http://localhost/demo3
        6.  获取协议及版本
            *	String getProtocol()
        7.获取客户机的IP地址
            *	String  getRemoteAddr()
        * */
        // 1.  获取请求方式 ：GET
        System.out.println("=====1.  获取请求方式 ：GET====");
        String method = request.getMethod();
        System.out.println(method);

        //2.  (*)获取虚拟目录：/我这里设为空
        System.out.println("=====获取虚拟目录：/我这里设为空=====");
        System.out.println(request.getContextPath());

        //3.获取Servlet路径： /demo3
        System.out.println("=====获取Servlet路径： /demo3=====");
        System.out.println(request.getServletPath());

        //  4.获取get方式请求参数：username=3516697
        System.out.println("=====获取get方式请求参数：username=3516697=====");
        System.out.println(request.getQueryString());

        //5.1 (*)获取请求URI ：/虚拟目录/demo3(虚拟目录我设为空)
        System.out.println("=====获取请求URI ：/虚拟目录/demo3(虚拟目录我设为空)=====");
        System.out.println(request.getRequestURI());

        //5.2获取请求URI ：/虚拟目录/demo3(虚拟目录我设为空)
        System.out.println("=====获取请求URI ：/虚拟目录/demo3(虚拟目录我设为空)=====");
        System.out.println(request.getRequestURL());

        //6. 获取协议及版本
        System.out.println("===== 获取协议及版本=====");
        System.out.println(request.getProtocol());

        //7.获取客户机的IP地址
        System.out.println("=====获取客户机的IP地址=====");
        System.out.println(request.getRemoteAddr());
    }
}
