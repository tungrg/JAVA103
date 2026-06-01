package com.slide1.Servlet;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/el")
public class El extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("x", "Hello request");
        req.getSession().setAttribute("y", "Hello session");
        req.getServletContext().setAttribute("z", "Hello application");
        Date now = new Date();
        req.setAttribute("now123", now);
        req.setAttribute("MSSV", "B123456");
        Map<String, Float> map = new HashMap<>();
        map.put("a", 1.0f);
        map.put("b", 2.0f);
        req.setAttribute("map", map);
        List<String> listTen = List.of("Nguyen Van A", "Tran Thi B", "Le Van C", 
        "Pham Thi D", "Do Van E",
        "Hoang Thi F", "Vu Van G", "Phan Thi H", "Dang Van I", "Bui Thi K");
        req.setAttribute("listTen123", listTen);

        req.getRequestDispatcher("/el.jsp").forward(req, resp);
        
    }

}