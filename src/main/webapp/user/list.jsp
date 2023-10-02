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
    <title>List User</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>
<h3><a href="users?action=create" style="text-decoration: none">Create new user</a></h3>
<h3><a href="users?action=search" style="text-decoration: none">Search</a></h3>

<table class="table">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Age</th>
        <th>Country</th>
        <th>Work</th>
    </tr>
    <c:forEach items="${requestScope['list']}" var="user">
        <tr>
            <td>${user.getId()}</td>
            <td>${user.getName()}</td>
            <td>${user.getAge()}</td>
            <td>${user.getContry()}</td>
            <td>
                <a href="users?action=update&id=${user.getId()}">update</a>
                <a href="users?action=delete&id=${user.getId()}">delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
