package com.slide1.Servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.IOException;

@WebServlet("/hello")
public class Hello extends HttpServlet {
    protected void doGet(HttpServletRequest request,
         HttpServletResponse response) throws ServletException, IOException {
        //response.getWriter().println("<h1>Hello, FPT Polytechnic!</h1>");
        request.getRequestDispatcher("/hello.jsp").forward(request, response);
    }

}
