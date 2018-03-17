package com.app.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {
    private static final String URL = "jdbc:mysql://localhost:3306?useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "22marta1993";

    public static Connection getConnect() {

        Connection connection;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException("Couldn't get connection", e);
        }
        return connection;
    }
}
