package com.slide1.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.slide1.Dao.UserDao;
import com.slide1.Entity.User;
import com.slide1.Util.DbConnector;

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
