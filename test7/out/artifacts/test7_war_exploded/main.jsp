<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2018/11/14
  Time: 10:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="vo.Category" %>
<%@ page import="java.util.List" %>
<%@ page import="dao.impl.CategoryDaoImpl" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="css/bootstrap.min.css" rel="stylesheet"/>
    <link href="css/style.css" rel="stylesheet"/>
    <title>网上书店</title>
</head>
<body onload="initAJAX()">
<div class="modal fade" id="myModal">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header"></div>
            <div class="modal-body"></div>
            <div class="modal-footer"></div>
        </div>
    </div>
</div>

<div class="header">
    <div class="container">
        <div class="row">
            <div class="login span4">
                <h1><a href=""> 欢迎来到<strong>我的</strong>书店</a>
                    <span class="red">.</span></h1>
            </div>
            <div class="links span8">
                <a class="login" href="login.html" rel="tooltip" data-placement="bottom" data-toggle="modal" data-target="#myModal"></a>
                <a class="register" href="" rel="tooltip" data_placement="bottom"></a>
            </div>
        </div>
    </div>
</div> <%--header--%>

<div class="row"> <%--下方左右div控制--%>
    <div class="col-md-3"> <%--左侧菜单div控制--%>
        <ul class="nav nav-list">
            <li class="nav-header">书籍类型</li>
            <%
                Object categories = request.getAttribute("categories");
                List<Category> categoryList = null;
                if (categories instanceof List) {
                    categoryList = (List<Category>)categories;
                }
                if (categories != null) {
                    for (Category category:categoryList) {
            %>
            <li>
                <a href="<%=category.getId()%>")>
                    <%=category.getName()%>
                </a>
            </li>
            <%
                    }
                }
            %>



        </ul>
    </div><%--左侧菜单div控制--%>

    <div class="col-md-9" id="book"><%-- 书籍布局控制--%>

    </div> <%-- 书籍布局控制--%>
</div><%--下方左右div控制--%>

<script src="js/jquery.min.js" ></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/commons.js"></script>
</body>
</html>
