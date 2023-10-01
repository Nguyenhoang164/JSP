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
    <title>Delete page</title>
</head>
<body>
<h1>Delete product</h1>
<p>
    <a href="products">Back to Product list</a>
</p>
<form method="post">
    <h3>Are you sure?</h3>
    <fieldset>
        <legend>Customer information</legend>
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
                <td><input type="submit" value="delete"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
