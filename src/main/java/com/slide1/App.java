package com.slide1;

import java.sql.DriverManager;

import org.mariadb.jdbc.Connection;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        String url = "jdbc:mariadb://localhost:3306/demo";
        //String url = "jdbc:sqlserver://localhost:3306;databaseName=1433;encrypt=false;trustServerCertificate=true";
        String username = "admin";
        //String username = "root";
        String password = "1234";
        try{
            Connection conn = (Connection) DriverManager.getConnection(url,username,password);
            System.out.println("Connected to the database!");
            String createTable = "CREATE TABLE IF NOT EXISTS users" + 
            "(id INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(255), email VARCHAR(255))";
            conn.createStatement().execute(createTable);
            String insertUser = "INSERT INTO users (name, email) VALUES ('John Doe', 'john.doe@example.com')";
            conn.createStatement().execute(insertUser);
            System.out.println("Table created successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
