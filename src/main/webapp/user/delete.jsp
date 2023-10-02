<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 27/09/2023
  Time: 2:40 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete User</title>
</head>
<body>
<form method="post">
    <table>
        <tr>
            <td>Name :</td>
            <td>${requestScope['user'].getName()}</td>
        </tr>
        <tr>
            <td>Age :</td>
            <td>${requestScope['user'].getAge()}</td>
        </tr>
        <tr>
            <td>Country :</td>
            <td>${requestScope['user'].getContry()}</td>
        </tr>
        <tr>
            <td><input type="submit" value="delete"></td>
            <td><a href="users">Back to List</a></td>
        </tr>
    </table>
</form>
<c:if test="${requestScope['message'] != null}">
    <span>${requestScope['message']}</span>
</c:if>
</body>
</html>
