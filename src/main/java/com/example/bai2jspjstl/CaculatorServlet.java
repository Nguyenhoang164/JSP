package com.example.bai2jspjstl;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "CaculatorServlet", value = "/Caculator-servlet")
public class CaculatorServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
      int number1 = Integer.parseInt(request.getParameter("number1"));
      int number2 = Integer.parseInt(request.getParameter("number2"));
      String value = request.getParameter("opration");
      PrintWriter printWriter = response.getWriter();
      try {
          float number = Caculator.calculate(number1,number2,value);
          printWriter.println( number1 + value + number2 + " = " + number);
      }catch (Exception e){
          printWriter.println(e);
      }
    }

    public void destroy() {
    }
}