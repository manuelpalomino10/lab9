package com.example.lab9_20205946.daos;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDao {
    public Connection getConnection() throws SQLException {

        try {
            Class.forName("com.mysql.jdbc.Driver");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String URL = "jdbc:mysql://localhost:3306/lab9";
        String USER = "root";
        String PASSWORD = "root";
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
