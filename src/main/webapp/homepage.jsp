<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 17/09/2023
  Time: 7:39 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String name = (String) session.getAttribute("name");
    PrintWriter printWriter = response.getWriter();
    printWriter.println("Welcome " + name + " to the page");
%>
<a href="logout">logOut</a>
</body>
</html>
