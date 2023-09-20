<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 17/09/2023
  Time: 7:20 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
  String name = request.getParameter("username");
  PrintWriter printWriter = response.getWriter();
  printWriter.println("user " + name + " to page ");
  session.setAttribute("user",name);
%>
<a href="second.jsp">more detail</a>
</body>
</html>
