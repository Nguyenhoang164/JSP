package com.example.jspjstl2;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
@WebServlet(name = "BanHangServlet",value = "/form")
public class BanHangServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        System.out.println(name);
        List<Stuff> listCheck = JDBC.getAll();
        for (Stuff item : listCheck) {
                if (name.equals(item.getName())){
                    resp.sendRedirect("buy.jsp");
                    JDBC.AddStuffToDataBase(item);
                }
            }
    }
}