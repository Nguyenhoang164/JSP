<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 21/09/2023
  Time: 9:21 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Product</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">
</head>
<body>
<div  style="text-align: center">
    <h1>Danh sach hang hoa quan ly</h1>
</div>
<div style="text-align: center">
    <a href="products?action=create"><i class="bi bi-person-plus-fill"></i></a>
    <a href="products?action=search"><i class="bi bi-search"></i></a>
</div>
<table class="table">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Prize</th>
        <th>Status</th>
        <th>HouseCreate</th>
        <th>Edit</th>
        <th>Delete</th>
        <th>Detail</th>
    </tr>
    <c:forEach var="product" items="${requestScope['list']}">
        <tr>
            <td>${product.getId()}</td>
            <td>${product.getName()}</td>
            <td>${product.getPrize()}</td>
            <td>${product.getStatus()}</td>
            <td>${product.getHouseProduct()}</td>
            <td><a href="products?action=edit&id=${product.getId()}" style="text-decoration: none"><i class="bi bi-pen"></i></a></td>
            <td><a href="products?action=delete&id=${product.getId()}" style="text-decoration: none"><i class="bi bi-person-x-fill"></i></a> </td>
            <td><a href="products?action=view&id=${product.getId()}" style="text-decoration: none"><i class="bi bi-card-list"></i></a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
