<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 27/09/2023
  Time: 3:45 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>
<a href="users" style="text-decoration: none">Back to List page</a>
<form method="post">
    Country : <input type="text" name="contry" placeholder="input search">
    <input type="submit" value="search">
</form>
<table class="table">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Age</th>
        <th>Country</th>
    </tr>
    <c:forEach items="${requestScope['list']}" var="user">
        <tr>
            <td>${user.getId()}</td>
            <td>${user.getName()}</td>
            <td>${user.getAge()}</td>
            <td>${user.getContry()}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
