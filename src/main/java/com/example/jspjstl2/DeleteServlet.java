package com.example.jspjstl2;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
@WebServlet(name = "DeleteServlet" , value = "/delete")
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        JDBC.DeleteStuffToDataBase();
        JDBC.getBuy();
        resp.sendRedirect("buy.jsp");
    }
}
