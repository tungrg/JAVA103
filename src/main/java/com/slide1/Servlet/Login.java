package com.slide1.Servlet;

import java.io.IOException;


import com.slide1.Dao.UserDao;
import com.slide1.Entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class Login extends HttpServlet {
    UserDao userDao = new UserDao();

    protected void doGet(HttpServletRequest request,
         HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }
    protected void doPost(HttpServletRequest request,
         HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        try {
            User user = userDao.findByUsernameAndPassword(username, password);
            if (user != null) {
                response.getWriter().println("<h1>Login successful!</h1>");
                return;
            }
            
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        response.getWriter().println("<h1>Login failed!</h1>");
        return;
       
    }


}
