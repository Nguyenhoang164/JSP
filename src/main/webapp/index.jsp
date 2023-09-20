<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Chuyển đổi tiền tệ</title>
    <link rel="stylesheet" type="text/css">
</head>
<body style="display: inline-block">
<h2>Chuyển đổi tiền tệ </h2>
<form action="trans.jsp" method="post">
    <label>
        <h3>Rate : </h3><br/>
        <input type="text" name="rate" placeholder="input rate here" >
    </label>
    <label>
        <h3>USD : </h3>
        <input type="text" name="usd" placeholder="input usd here" >
    </label>
    <input type="submit" value="submit" id="submit">
</form>
</body>
</html>