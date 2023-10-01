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
</head>
<body>
<h1>Edit customer</h1>
<p>
    <c:if test='${requestScope["message"] != null}'>
        <span class="message">${requestScope["message"]}</span>
    </c:if>
</p>
<p>
    <a href="products">Back to Product list</a>
</p>
<form method="post">
    <fieldset>
        <legend>Customer information</legend>
        <table>
            <tr>
                <td>Name: </td>
                <td><input type="text" name="name" id="name" value="${requestScope["product"].getName()}"></td>
            </tr>
            <tr>
                <td>Prize: </td>
                <td><input type="text" name="prize" id="prize" value="${requestScope["product"].getPrize()}"></td>
            </tr>
            <tr>
                <td>Status: </td>
                <td><input type="text" name="status" id="status" value="${requestScope["product"].getStatus()}"></td>
            </tr>
            <tr>
                <td>House Create: </td>
                <td><input type="text" name="houseCreate" id="houseCreate" value="${requestScope["product"].getHouseProduct()}"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="edit"></td>

        </table>
    </fieldset>
</form>
</body>
</html>
