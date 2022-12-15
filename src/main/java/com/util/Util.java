package com.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    public static final String URL = "jdbc:h2:C:\\Users\\wk\\IdeaProjects\\Students\\Ivan";//"jdbc:mysql://localhost:3306/newbd";
    public static final String NAME = "sa";
    public static final String PASSWORD = "";

    static Connection connection = null;

    public static Connection getConnection() {
        try {
            connection = DriverManager.getConnection(URL, NAME, PASSWORD);
        } catch (SQLException e) {
            System.out.println("<<<<<<<<< Util >>>>>>>>\n" + "Ошибка подключения");
            e.printStackTrace();
        }
        return connection;
    }
}
