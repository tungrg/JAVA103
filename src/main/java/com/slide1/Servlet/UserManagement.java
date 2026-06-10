package com.slide1.Servlet;

import java.io.IOException;
import java.util.List;

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


@WebServlet("/user-management")
public class UserManagement extends HttpServlet {
    UserDao userDao = new UserDao();
    // Implement methods for user management (CRUD operations)
    @Override
    protected void doGet(HttpServletRequest request,
         HttpServletResponse response) throws ServletException, IOException {
        // Handle GET requests for listing users or showing user details
        List<User> users = userDao.findAll();
        // for(User user : users) {
        //     System.out.println("User: " + user.getEmail() + ", " + user.getUsername());
        // }

        request.setAttribute("users", users);
        request.getRequestDispatcher("/WEB-INF/user-management.jsp").forward(request, response);

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("Save User".equals(action)) {
            String email = request.getParameter("email");
            String username = request.getParameter("username");
            int age = Integer.parseInt(request.getParameter("age"));
            String password = request.getParameter("password");
            User user = new User(email, username, age, password);
            if (userDao.findByEmail(email) != null){
                // if email already exists, update the user
                User existingUser = userDao.findByEmail(email);
                existingUser.setUsername(username);
                existingUser.setAge(age);
                existingUser.setPassword(password);
                userDao.update(existingUser);
            } else {
                // if email does not exist, save new user
                userDao.save(user);
            }
        } else if ("Delete".equals(action)) {
            long id = Long.parseLong(request.getParameter("id"));
            User user = userDao.findById(id);
            if (user != null) {
                userDao.delete(user);
            }
        }
        // Redirect to the same page to refresh the user list
        response.sendRedirect("user-management");
    }

}
