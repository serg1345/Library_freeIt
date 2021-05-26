package by.sergey_l.dao;

import java.sql.*;

public class MySQLConnection {
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost/library";
        String username = "root";
        String password = "12345678";
        return DriverManager.getConnection(url, username, password);
    }
}
