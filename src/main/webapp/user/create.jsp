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
    <title>Create User</title>
</head>
<body>

<form method="post">
    <table>
        <tr>
            <td>Name :</td>
            <td><input type="text" name="name" placeholder="input name here"></td>
        </tr>
        <tr>
            <td>Age :</td>
            <td><input type="number" name="age" placeholder="input age here"></td>
        </tr>
        <tr>
            <td>Country :</td>
            <td><input type="text" name="contry" placeholder="input country here"></td>
        </tr>
        <tr>
            <td><input type="submit" value="create"></td>
            <td><a href="users">Back to List</a></td>
        </tr>
    </table>
    <c:if test="${requestScope['message'] != null}">
        <span>${requestScope['message']}</span>
    </c:if>
</form>
</body>
</html>
