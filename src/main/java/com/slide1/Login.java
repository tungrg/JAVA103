package com.slide1;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mariadb.jdbc.Connection;

@WebServlet("/login")
public class Login extends HttpServlet {
    Connection connection = DbConnector.getConnection();

    protected void doGet(HttpServletRequest request,
         HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }
    protected void doPost(HttpServletRequest request,
         HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        try {
            String query = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                request.getRequestDispatcher("/hello.jsp").forward(request, response);
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
