package com.slide1.Scope;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

// trong truong hop su dung jetty version 11.x thi su dung jakarta.servlet thay vi javax.servlet, neu khong chay duoc thi doi import tu jakarta.servlet sang javax.servlet
//ko chay duoc thi import jakarta.servlet.ServletContext; --- IGNORE ---
//ko chay duoc thi import jakarta.servlet.ServletContextEvent; --- IGNORE ---
//ko chay duoc thi import jakarta.servlet.ServletContextListener; --- IGNORE ---
//ko chay duoc thi import jakarta.servlet.annotation.WebListener; --- IGNORE ---

import com.slide1.Util.DbConnector;

@WebListener
public class AppContextListener implements ServletContextListener  {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // Lay servlet context de su dung chung trong toan bo ung dung
        ServletContext app = sce.getServletContext();
        // Ket noi toi database khi ung dung duoc khoi dong
        DbConnector.init();
        System.out.println("Application context initialized.");


    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // Lay servlet context de su dung chung trong toan bo ung dung
        ServletContext app = sce.getServletContext();
        // Dong ket noi toi database khi ung dung bi tat
        DbConnector.close();
        System.out.println("Application context destroyed.");
    }

}
