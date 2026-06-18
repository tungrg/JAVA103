package com.slide1.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.slide1.Entity.Video;
import com.slide1.Util.DbConnector;


@WebServlet("/videos")
public class VideoServlet extends HttpServlet {
    
    // Implement methods for video management (CRUD operations)
    @Override
    protected void doGet(HttpServletRequest request,
         HttpServletResponse response) throws ServletException, IOException {
        // Handle GET requests for listing videos or showing video details
        //return all video as json
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        DbConnector.em.getTransaction().begin();
        List<Video> videos = DbConnector.em.createQuery("SELECT v FROM Video v", Video.class).getResultList();
        DbConnector.em.getTransaction().commit();
        Gson gson = new Gson();
        String json = gson.toJson(videos);
        response.getWriter().write(json);
    }


}
