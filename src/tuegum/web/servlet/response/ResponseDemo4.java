package tuegum.web.servlet.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 服务器输出字符数据到浏览器
 */

@WebServlet("/responseDemo4")
public class ResponseDemo4 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //解决中文乱码
//        response.setHeader("content-type","text/html;charset=UTF-8");
//        response.setCharacterEncoding("UTF-8");

        //解决中文乱码简化
        response.setContentType("text/html;charset=UTF-8");

        //获取字符输出流
        PrintWriter pw = response.getWriter();
        pw.write("<h1>你好</h1>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
