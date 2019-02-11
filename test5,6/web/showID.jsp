<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2018/11/14
  Time: 10:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String id =request.getParameter("id");
    String pwd =request.getParameter("pwd");
    out.println("id:"+id+"<br>");
    out.print("pwd:"+pwd);
%>

</body>
</html>
