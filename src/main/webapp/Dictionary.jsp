<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 13/09/2023
  Time: 12:31 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Translate to English</title>
</head>
<body>
<%!
    Map<String,String> list = new HashMap<>();
%>
<%
    list.put("hello","xin chao");
    list.put("Pen", "bút");
    list.put("how", "Thế nào");
    list.put("book", "Quyển vở");
    list.put("computer", "Máy tính");
    String search = request.getParameter("search");
    String result = list.get(search);
    String value;
    if (result != null){
        value = result;
    }else{
        value = "loi khong tim thay ";
    }
%>
<h3>result : <%=value%></h3>
</body>
</html>
