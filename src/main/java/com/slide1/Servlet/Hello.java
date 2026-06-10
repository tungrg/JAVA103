package com.slide1.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//jetty version 11.x su dung jakarta.servlet thay vi javax.servlet, neu khong chay duoc thi doi import tu jakarta.servlet sang javax.servlet
//ko chay duoc thi import jakarta.servlet.ServletException; --- IGNORE ---
//ko chay duoc thi import jakarta.servlet.annotation.WebServlet; --- IGNORE ---
//ko chay duoc thi import jakarta.servlet.http.HttpServlet; --- IGNORE ---
//ko chay duoc thi import jakarta.servlet.http.HttpServletRequest; --- IGNORE ---
//ko chay duoc thi import jakarta.servlet.http.HttpServletResponse; --- IGNORE --

@WebServlet("/hello")
public class Hello extends HttpServlet {
    protected void doGet(HttpServletRequest request,
         HttpServletResponse response) throws ServletException, IOException {
        //response.getWriter().println("<h1>Hello, FPT Polytechnic!</h1>");
        request.getRequestDispatcher("/hello.jsp").forward(request, response);
    }

}
