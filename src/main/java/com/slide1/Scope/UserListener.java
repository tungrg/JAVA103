package com.slide1.Scope;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

// trong truong hop su dung jetty version 11.x thi su dung jakarta.servlet thay vi javax.servlet, neu khong chay duoc thi doi import tu jakarta.servlet sang javax.servlet
//ko chay duoc thi import jakarta.servlet.ServletContext; --- IGNORE ---
//ko chay duoc thi import jakarta.servlet.ServletContextEvent; --- IGNORE ---
//ko chay duoc thi import jakarta.servlet.ServletContextListener; --- IGNORE ---
//ko chay duoc thi import jakarta.servlet.annotation.WebListener; --- IGNORE ---


@WebListener
public class UserListener implements HttpSessionListener{
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("Session created: " + se.getSession().getId());
    }
    @Override
    public void sessionDestroyed(HttpSessionEvent se){
        System.out.println("Session destroyed: " + se.getSession().getId());
    }

}
