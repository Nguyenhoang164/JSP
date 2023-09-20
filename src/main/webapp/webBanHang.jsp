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
</style>
<body>
<header style="width: 100%;height: 150px;text-align: center;background-image: url('https://motgame.vn/wp-content/uploads/2022/09/Blue_Archive.jpg');">
    <h1 style="text-align: center">Trang web bán hàng</h1>
        <ul>
            <li><a href="#">Sản phẩm</a></li>
            <li><a href="buy.jsp">Giỏ hàng</a></li>
            <li><a href="#">Liên hệ</a></li>
        </ul>
    <h2 style="text-align: center">Sản phẩm nổi bật</h2>

</header>
<form action="form" method="post">
  tên hàng : <input type="text" name="name" placeholder="name here"> <input type="submit" value="Buy">
</form>
<main style="color: red ;height: 600px;padding-top: 30px ">
<section style="display: inline-flex;">

<%
    List<Stuff> list = JDBC.getAll();
    request.setAttribute("list",list);
%>


    <c:forEach var="stuff" items="${list}">
        <div style="padding-right: 70px">
            <img src="${stuff.url}" style="width: 150px;height: 150px">
            <h3>${stuff.name}</h3>
            <p>${stuff.status}</p>
            <p>${stuff.prize} <img src="https://files.cults3d.com/uploaders/19685247/illustration-file/b23a78c1-14ed-435d-92b1-1eb38e7712a6/1658060193.png" style="width:20px;height: 30px"></p>
        </div>
    </c:forEach>
</section>
</main>

<footer>
    <p style="text-align: center">Bản quyền &copy; 2023 Trang web bán hàng</p>

</footer>
<div class="clear"></div>
</body>
</html>
