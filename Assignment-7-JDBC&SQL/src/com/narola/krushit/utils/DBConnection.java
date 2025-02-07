package com.narola.krushit.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public static Connection getConnection() throws SQLException {
        String DB_URL = "jdbc:mysql://localhost:3306/sql_my_learn";
        String DB_USER_NAME = "root";
        String DB_PASSWORD = "password123#";

        return DriverManager.getConnection(DB_URL, DB_USER_NAME, DB_PASSWORD);
    }
}
