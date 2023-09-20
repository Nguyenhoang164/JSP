package com.example.jspjstl2;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
       String name = request.getParameter("username");
       String password = request.getParameter("password");
       if (name.equals("admin") && password.equals("admin")){
           HttpSession session = request.getSession();
           session.setAttribute("name",name);
           response.sendRedirect("homepage.jsp");
       }else{
           response.sendRedirect("homeError.jsp");
       }
    }

    public void destroy() {
    }
}