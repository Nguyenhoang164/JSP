<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.jspjstl2.Stuff" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Collection" %>
<%@ page import="java.sql.*" %>
<%@ page import="com.example.jspjstl2.JDBC" %><%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 17/09/2023
  Time: 7:51 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Trang web bán hàng</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">
</head>
<style>
    ul{
        list-style: none;

    }
    li {
        text-align: center;
        display: inline-block;
        padding: 14px 16px;
    }
    a{
        text-decoration: none;
    }
    .product{
        padding-left: 100px;
    }
    td{
      height: 100px;
    }
</style>
<body >
<header style="width: 100%;height: 150px;text-align: center;background-image: url('https://motgame.vn/wp-content/uploads/2022/09/Blue_Archive.jpg');">
    <h1 style="text-align: center">Trang web bán hàng</h1>
    <ul>
        <li><a href="webBanHang.jsp">Trang chủ</a></li>
        <li><a href="#">Sản phẩm</a></li>
        <li><a href="#">Liên hệ</a></li>
    </ul>
</header>
<main style="color: red ;height: 1000px;padding-top: 30px ">
   <a href="delete" ><i class="bi bi-trash"></i></a>
    <%
        List<Stuff> list = JDBC.getBuy();
        request.setAttribute("list",list);
    %>
    <table class="table">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Prize</th>
            <th>Picture</th>
        </tr>
        <c:forEach var="stuff" items="${list}">
            <tr>
                <td>${stuff.id}</td>
                <td>${stuff.name}</td>
                <td>${stuff.prize} <img src="https://files.cults3d.com/uploaders/19685247/illustration-file/b23a78c1-14ed-435d-92b1-1eb38e7712a6/1658060193.png" style="width:20px;height: 30px"></td>
                <td><img src="${stuff.url}" style="width: 50px;height: 50px"></td>
            </tr>
        </c:forEach>
    </table>
</main>

<footer>
    <p style="text-align: center">Bản quyền &copy; 2023 Trang web bán hàng</p>

</footer>
<div class="clear"></div>
</body>

</html>
