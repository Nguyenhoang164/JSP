<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 13/09/2023
  Time: 12:49 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Simple Caculator</title>
</head>
<body>
<form action="Caculator-servlet" method="post">
    <label>
        <h3>Number 1 : </h3>
        <input type="number" name="number1" placeholder="input number here">
    </label>
    <label>
        <h3>Number 2 : </h3>
        <input type="number" name="number2" placeholder="input number here">
    </label>
    <label>
        <select name="opration">
            <option value="">--------</option>
            <option value="+">+</option>
            <option value="-">-</option>
            <option value="*">*</option>
            <option value="/">/</option>
        </select>
    </label>
    <input type="submit" value="Check">
</form>
</body>
</html>
