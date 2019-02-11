<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2018/11/14
  Time: 10:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.sql.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Class.forName("org.sqlite.JDBC");
    String url = "jdbc:sqlite:D:/dropbox/bookstore.db";
    String sql = "select id,name,author,price,image,description,category_id from book" +
            " where category_id = ?";
    String categoryID = request.getParameter("id");
    Connection conn = DriverManager.getConnection(url);
    PreparedStatement pstat = conn.prepareStatement(sql);
    pstat.setString(1,categoryID);
    ResultSet rs = pstat.executeQuery();
    while (rs.next()) {
%>
<div class="col-sm-9 col-md-3"><div class="thumbnail" ><img src="images/book.jpg"><div class="caption">  <h4>
    <%=rs.getString("name")%>
</h4><p><%=rs.getString("description")%>
</p><p><a href="#" class="btn btn-primary" role="button">加入购物车</a> <a href="#" class="btn btn-default" role="button">查看详情
</a></p></div></div> </div>
<%
    }
    pstat.close();
    conn.close();
%>

</body>
</html>
