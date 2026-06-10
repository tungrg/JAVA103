package com.slide1.Servlet;

import java.io.IOException;
//jetty version 9.x.x su dung javax.servlet thay vi jakarta.servlet, neu khong chay duoc thi doi import tu javax.servlet sang jakarta.servlet
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

@WebServlet("/home")
public class Home extends HttpServlet {
    // Implement methods for home page
    @Override
    protected void doGet(HttpServletRequest request,
        HttpServletResponse response) throws ServletException, IOException {
        // Lay ra bien visitCount tu application scope de hien thi so lan truy cap
        Integer visitCount = (Integer) request.getServletContext().getAttribute("visitCount");
        // Neu visitCount chua ton tai, khoi tao no bang 0
        if (visitCount == null) {
            visitCount = 0;
        }
        // Tang visitCount len 1 va luu lai vao application scope
        visitCount++;
        request.getServletContext().setAttribute("visitCount", visitCount);
        // Forward request den home.jsp de hien thi trang chu
        request.getRequestDispatcher("/home.jsp").forward(request, response);
    }

}
