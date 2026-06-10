package com.slide1.Servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


import com.slide1.Dao.UserDao;
import com.slide1.Entity.User;

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

@WebServlet("/dangky")
public class DangKy extends HttpServlet {
    UserDao userDao = new UserDao();
    
    protected void doGet(HttpServletRequest request,
         HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/dangky.jsp").forward(request, response);
    }
    protected void doPost(HttpServletRequest request,
         HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String username = request.getParameter("username");
        String age = request.getParameter("age");
        String password = request.getParameter("password");
        Map<String, String> errors = new HashMap<>();
        if (email == null || email.isEmpty()) {
            errors.put("email", "Email is required");
        }
        if (username == null || username.isEmpty()) {
            errors.put("username", "Username is required");
        }
        if (age == null || age.isEmpty()) {
            errors.put("age", "Age is required");
        } else {
            try {
                int ageValue = Integer.parseInt(age);
                if (ageValue < 18) {
                    errors.put("age", "Age must be at least 18");
                }
            } catch (NumberFormatException e) {
                errors.put("age", "Age must be a valid number");
            }
        }
        if (password == null || password.isEmpty()) {
            errors.put("password", "Password is required");
        }
        if (!errors.isEmpty()) {
            request.setAttribute("error", errors);
            request.getRequestDispatcher("/dangky.jsp").forward(request, response);
            return;
        }

        User user = new User(email, username, Integer.parseInt(age), password);
        userDao.save(user);
        response.getWriter().println("<h1>Registration successful!</h1>");
    }

}
