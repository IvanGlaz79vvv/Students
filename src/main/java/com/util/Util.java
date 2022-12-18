package com.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    public static final String URL = "jdbc:mysql://localhost:3306/Students";//"jdbc:mysql://localhost:3306/newbd";
    public static final String NAME = "root";
    public static final String PASSWORD = "root";

    static Connection connection = null;

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, NAME, PASSWORD);
            System.out.println("----Подключение установлено----");
        } catch (SQLException e) {
            System.out.println("<<<<<<<<< Util >>>>>>>>\n" + "Ошибка подключения");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("<<<<<Util.getConnection()>>>>>> ClassNotFoundException e");
            throw new RuntimeException(e);
        }
        return connection;
    }
}
