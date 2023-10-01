<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 21/09/2023
  Time: 1:40 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>
<a href="products">Back to list</a>
<form method="post">
    <table class="table">
        <tr>
            <td>ID : </td>
            <td><input type="number" name="id" placeholder="input id here !"></td>
        </tr>
        <tr>
            <td>Name : </td>
            <td><input type="text" name="name" placeholder="input name here !"></td>
        </tr>
        <tr>
            <td>Prize : </td>
            <td><input type="text" name="prize" placeholder="input prize here !"></td>
        </tr>
        <tr>
            <td>Status : </td>
            <td><input type="text" name="status" placeholder="input status here !"></td>
        </tr>
        <tr>
            <td>House Product : </td>
            <td><input type="text" name="product" placeholder="input product here !"></td>
        </tr>
        <tr>
            <td><input type="submit" value="search"></td>
        </tr>
    </table>
</form>
<table class="table">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Prize</th>
        <th>Status</th>
        <th>House Product</th>
    </tr>
    <c:forEach var="product" items="${requestScope['listResult']}">
        <tr>
            <td>${product.getId()}</td>
            <td>${product.getName()}</td>
            <td>${product.getPrize()}</td>
            <td>${product.getStatus()}</td>
            <td>${product.getHouseProduct()}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
