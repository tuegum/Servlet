<%@ page import="java.net.URLDecoder" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.net.URLEncoder" %><%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 2020/6/26
  Time: 8:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Cookie[] cookies = request.getCookies();
    boolean flag = false;
    if (cookies != null && cookies.length > 0) {
        for (Cookie cookie : cookies) {
            String name = cookie.getName();
            if ("last_time".equals(name)) {
                flag = true;
                String value = cookie.getValue();
                value = URLDecoder.decode(value, "utf-8");
//                    response.reset();
%>

                <h1>欢迎回来，您上次的访问时间为：<%=value%></h1>
<%
                Date date = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
                String sdf_date = sdf.format(date);
                System.out.println("编码前：" + sdf_date);
                //URL编码
                sdf_date = URLEncoder.encode(sdf_date, "utf-8");
                System.out.println("编码后：" + sdf_date);
                cookie.setValue(sdf_date);
                cookie.setMaxAge(60 * 60 * 24 * 30);
                response.addCookie(cookie);
                break;
            }
        }
    }
    if (cookies != null || cookies.length == 0 || flag == false) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        String sdf_date = sdf.format(date);
        sdf_date = URLEncoder.encode(sdf_date, "utf-8");
        Cookie cookie = new Cookie("last_time", sdf_date);
        cookie.setMaxAge(60 * 60 * 24 * 30);
        response.addCookie(cookie);
%>
<h1>您好，欢迎您首次登录</h1>
<%
    }
%>
</body>
</html>
