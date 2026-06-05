package com.slide1.Util;

import com.slide1.Entity.Video;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class AppContextListener implements ServletContextListener  {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // Initialize resources, such as database connections or thread pools
        DbConnector.init();
        System.out.println("Application context initialized.");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // Clean up resources, such as closing database connections or shutting down thread pools
        DbConnector.close();
        System.out.println("Application context destroyed.");
    }

}
