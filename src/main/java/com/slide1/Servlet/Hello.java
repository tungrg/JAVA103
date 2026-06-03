package com.slide1.Servlet;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class Hello extends HttpServlet {
    protected void doGet(HttpServletRequest request,
         HttpServletResponse response) throws ServletException, IOException {
        //response.getWriter().println("<h1>Hello, FPT Polytechnic!</h1>");
        request.getRequestDispatcher("/hello.jsp").forward(request, response);
    }

}
