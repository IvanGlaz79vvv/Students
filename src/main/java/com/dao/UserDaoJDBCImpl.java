package com.dao;

import com.util.Util;

import java.sql.*;

public class UserDaoJDBCImpl {
    public UserDaoJDBCImpl() {
    }

    private final Connection conn = Util.getConnection();

    private static final String CREATETABLE_Lesson = "CREATE TABLE IF NOT EXISTS Lesson" +
            "(id INT PRIMARY KEY AUTO_INCREMENT, " +
            "Lesson VARCHAR(255), " +
            "Lesson_id INT, " +
            "mark VARCHAR(255)," +
            "FOREIGN KEY (Lesson_id) REFERENCES Students (id))";
    private static final String CREATETABLE_Students = "CREATE TABLE IF NOT EXISTS Students" +
            "(id INT PRIMARY KEY AUTO_INCREMENT, " +
            "FIO VARCHAR(255), " +
            "ball INT, " +
            "lesson VARCHAR(255))";

    private static final String SAVE_Student = "INSERT INTO Students (FIO , ball , lesson) VALUES (?, ?, ?)";
    private static final String SAVE_Lesson = "INSERT INTO Lesson (Lesson, Lesson_id, mark) VALUES (?, ?, ?)";

    private static final String DELETE = "DELETE FROM Students WHERE id = ?";
    private static final String SAVE = "INSERT INTO Students (Name, Last_Name, age) VALUES (?, ?, ?)";
    private static final String SELECTALL = "SELECT * FROM Students";
    private static final String TRUNCATE = "TRUNCATE TABLE Students";

    //    @Override
    public void createUsersTable() throws SQLException {
        System.out.println("<<<createTable>>>: \n 1 = UNCOMMITTED  \n 2 = READ_COMMITTED \n 4 = REPEATABLE_READ \n 8 = SERIALIZABLE \n getTransactionIsolation: = " + conn.getTransactionIsolation());
        try (Statement statement = conn.createStatement()) {
            System.out.println(conn.getTransactionIsolation());

            conn.setAutoCommit(false);
            statement.executeUpdate(CREATETABLE_Students);
            statement.executeUpdate(CREATETABLE_Lesson);
            conn.commit();

        } catch (SQLException e) {
            e.printStackTrace();
            try {
                conn.rollback();
                System.out.println("^^^^^<<<Dao.createUsersTable>>> Сработал createTable -> rollback()^^^^^\n");
            } catch (SQLException ex) {
                System.out.println("\n-----<<<Dao.createUsersTable>>> Начало ошибки rollback() createTable-----");
                ex.printStackTrace();
                System.out.println("^^^^^<<<Dao.createUsersTable>>> Конец ошибки rollback() createTable^^^^^");
            }
        } finally {
            try {
                conn.setAutoCommit(true);
            } catch (SQLException e) {
                System.out.println("-----<<<Dao.createUsersTable>>> Начало ошибки setAutoCommit(true) createTable-----");
                e.printStackTrace();
                System.out.println("^^^^^<<<Dao.createUsersTable>>> Ошибка setAutoCommit(true) createTable^^^^^");
            }
        }
    }

    public void saveUserStudent(String FIO, int ball, String lesson) throws SQLException {
        conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
//        System.out.println("<<<Dao.saveUser>>>: \n 1 = UNCOMMITTED  \n 2 = READ_COMMITTED \n 4 = REPEATABLE_READ \n 8 = SERIALIZABLE \n getTransactionIsolation: = " + conn.getTransactionIsolation());

        conn.setAutoCommit(false);
        try (PreparedStatement pstmt = conn.prepareStatement(SAVE_Student)) {
            pstmt.setString(1, FIO);
            pstmt.setInt(2, ball);  // pstmt.setInt(ball);
            pstmt.setString(3, lesson);

            pstmt.executeUpdate();

            System.out.println("Пользователь: " + FIO + " добавлен в базу данных");
            conn.commit();

        } catch (SQLException e) {
            e.printStackTrace();
            try {
                conn.rollback();
                System.out.println("^^^^^<<<Dao.saveUserStudent>>> Сработал saveUserStudent -> rollback()^^^^^\n");
            } catch (SQLException ex) {
                System.out.println("\n-----<<<Dao.saveUserStudent>>> Начало ошибки rollback() saveUserStudent-----");
                ex.printStackTrace();
                System.out.println("^^^^^<<<Dao.saveUserStudent>>> Конец ошибки rollback() saveUserStudent^^^^^");
            }
        } finally {
            try {
                conn.setAutoCommit(true);
            } catch (SQLException e) {
                System.out.println("-----<<<Dao.saveUserStudent>>> Начало ошибки setAutoCommit(true) saveUserStudent-----");
                e.printStackTrace();
                System.out.println("^^^^^<<<Dao.saveUserStudent>>> Ошибка setAutoCommit(true) saveUserStudent^^^^^");
            }
        }
    }

    public void saveUserLesson(String lesson, int lesson_id, String mark) throws SQLException {
        conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
//        System.out.println("<<<Dao.saveUser>>>: \n 1 = UNCOMMITTED  \n 2 = READ_COMMITTED \n 4 = REPEATABLE_READ \n 8 = SERIALIZABLE \n getTransactionIsolation: = " + conn.getTransactionIsolation());

        conn.setAutoCommit(false);
        try (PreparedStatement pstmt = conn.prepareStatement(SAVE_Lesson)) {
            pstmt.setString(1, lesson);
            pstmt.setInt(2, lesson_id);
            pstmt.setString(3, mark);

            pstmt.executeUpdate();

            System.out.println("Урок: " + lesson + " c id: " + lesson_id + " добавлен в базу данных");
            conn.commit();

        } catch (SQLException e) {
            e.printStackTrace();
            try {
                conn.rollback();
                System.out.println("^^^^^<<<Dao.saveUserLesson>>> Сработал saveUserLesson -> rollback()^^^^^\n");
            } catch (SQLException ex) {
                System.out.println("\n-----<<<Dao.saveUserLesson>>> Начало ошибки rollback() saveUserLesson-----");
                ex.printStackTrace();
                System.out.println("^^^^^<<<Dao.saveUserLesson>>> Конец ошибки rollback() saveUserLesson^^^^^");
            }
        } finally {
            try {
                conn.setAutoCommit(true);
            } catch (SQLException e) {
                System.out.println("-----<<<Dao.saveUserStudent>>> Начало ошибки setAutoCommit(true) createTable-----");
                e.printStackTrace();
                System.out.println("^^^^^<<<Dao.saveUserStudent>>> Ошибка setAutoCommit(true) createTable^^^^^");
            }
        }
    }
}


//        @Override
//        public void dropUsersTable () throws SQLException {
//
//        }
//
//
//
//        @Override
//        public void removeUserById ( long id){
//
//        }
//
//        @Override
//        public void cleanUsersTable () {
//
//        }

