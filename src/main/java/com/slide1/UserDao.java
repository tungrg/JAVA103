package com.slide1;

import java.sql.PreparedStatement;

import org.mariadb.jdbc.Connection;

public class UserDao {
    private Connection connection = DbConnector.getConnection();
    public boolean registerUser(User user) {
        try {
            String query = "INSERT INTO users (email, username, age, password) VALUES (?, ?, ?, ?)";
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setString(1, user.getEmail());
            pstmt.setString(2, user.getUsername());
            pstmt.setInt(3, user.getAge());
            pstmt.setString(4, user.getPassword());
            int rowsInserted = pstmt.executeUpdate();
            return rowsInserted > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
