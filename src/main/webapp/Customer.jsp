<%@ page import="com.example.bai2jspjstl.People" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <title>JSP Page</title>
</head>
<body>
<div style="width: 100% ; height: 60px;text-align: center" >
    <h1>Danh sách khách hàng</h1>
</div>
<table class="table">
<thead>
    <tr style="height: 30px">
        <th>Name</th>
        <th>Date</th>
        <th>Address</th>
        <th>Picture</th>
    </tr>
    </thead>
    <%
        List<People> list = new ArrayList<>();
        list.add(new People("Nam", "11-12-2002", "Ha Noi","https://lwi.nexon.com/m_ba/brand/media/img_01_l.png"));
        list.add(new People("Hai", "11-12-2002",  "Ha Noi","https://lwi.nexon.com/m_ba/brand/media/img_01_l.png"));
        list.add(new People("hoa", "11-12-2002",  "Ha Noi","https://lwi.nexon.com/m_ba/brand/media/img_01_l.png"));
        list.add(new People("Thai", "11-12-2002",  "Ha Noi","https://lwi.nexon.com/m_ba/brand/media/img_01_l.png"));
        list.add(new People("Phong", "11-12-2002", "Ha Noi","https://lwi.nexon.com/m_ba/brand/media/img_01_l.png"));
        request.setAttribute("list",list);
    %>

    <c:forEach var="item" items="${list}">
        <tr>
            <td>${item.name}</td>
            <td>${item.date}</td>
            <td>${item.address}</td>
            <td><img src="${item.URL}" alt="picture" style="width: 50px;height: 50px;"></td>
        </tr>
    </c:forEach>
</table>>
</body>
</html>