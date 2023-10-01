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
    <title>View page</title>
</head>
<body>
<h1>Product details</h1>
<p>
    <a href="products">Back to Product list</a>

</p>
<table>
    <tr>
        <td>Name: </td>
        <td>${requestScope["product"].getName()}</td>
    </tr>
    <tr>
        <td>Prize: </td>
        <td>${requestScope["product"].getPrize()}</td>
    </tr>
    <tr>
        <td>Status: </td>
        <td>${requestScope["product"].getStatus()}</td>
    </tr>
    <tr>
        <td>House Product: </td>
        <td>${requestScope["product"].getHouseProduct()}</td>
    </tr>
    <tr>
        <td><button><a href="list.jsp">Back</a> </button></td>
    </tr>

</table>
</body>
</html>
