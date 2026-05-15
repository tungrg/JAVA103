package com.slide1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class Login extends HttpServlet {
    protected void doGet(HttpServletRequest request,
         HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }
    protected void doPost(HttpServletRequest request,
         HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if ("admin".equals(username) 
            && "1234".equals(password)) {
            request.getRequestDispatcher("/hello.jsp").forward(request, response);
        } else {
            response.getWriter().
            println("<h1>Login failed!</h1>");
        }
    }


}
