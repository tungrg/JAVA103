package com.slide1;

import java.sql.DriverManager;

import org.mariadb.jdbc.Connection;

public class DbConnector {
    static String url = "jdbc:mariadb://localhost:3306/demo";
    //String url = "jdbc:sqlserver://localhost:1433;databaseName=demo;encrypt=false;trustServerCertificate=true";
    static String username = "admin";
    //String username = "root";
    static String password = "1234";

    public static Connection connection = null;
    public static Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                connection = (Connection) DriverManager.getConnection(url, username, password);
                System.out.println("Connected to the database!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

}
