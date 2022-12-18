package com.service;

import com.dao.UserDaoJDBCImpl;
import com.util.Util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserServiceImpl {
    Connection conn = Util.getConnection();

    public void createUsersTable() throws SQLException {
        UserDaoJDBCImpl userDaoJDBC = new UserDaoJDBCImpl();
        userDaoJDBC.createUsersTable();
    }

    public void saveStudent() throws SQLException, IOException {
        conn.setAutoCommit(false);
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Введите FIO:");
            String FIO = reader.readLine();
            System.out.println("Введите ball:");
            int ball = Integer.parseInt(reader.readLine());
            System.out.println("Введите lesson:");
            String lesson = reader.readLine();


 /*           System.out.println("Введите lesson:");
            lesson = reader.readLine();
            System.out.println("lesson_id:");
            int lesson_id = Integer.parseInt(reader.readLine());
            System.out.println("Введите mark:");
             String mark = reader.readLine();
*/
            UserDaoJDBCImpl userDaoJDBC = new UserDaoJDBCImpl();
            userDaoJDBC.saveUserStudent(FIO, ball, lesson);
//            userDaoJDBC.saveUserLesson(lesson, lesson_id, mark);

//            UserDaoJDBCImpl userDaoJDBC = new UserDaoJDBCImpl();
//            reader.close();
            conn.commit();
        } catch (SQLException e) {
            System.err.println("<<<UserServiceImpl.try (BufferedReader reader = " +
                    "new BufferedReader(new InputStreamReader(System.in))));>>> \n" + e);
        } finally {
            conn.setAutoCommit(true);
        }
    }


    public void saveLesson() throws SQLException, IOException {
        conn.setAutoCommit(false);
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Введите lesson:");
            String lesson = reader.readLine();
            System.out.println("lesson_id:");
            int lesson_id = Integer.parseInt(reader.readLine());
            System.out.println("Введите mark:");
            String mark = reader.readLine();

            UserDaoJDBCImpl userDaoJDBC = new UserDaoJDBCImpl();
            userDaoJDBC.saveUserLesson(lesson, lesson_id, mark);
//            reader.close();
            conn.commit();
        } catch (SQLException e) {
            System.err.println("<<<UserServiceImpl.try (BufferedReader reader = " +
                    "new BufferedReader(new InputStreamReader(System.in))));>>> \n" + e);
        } finally {
            conn.setAutoCommit(true);
        }
    }
}


//    public void dropUsersTable() throws SQLException {
//        userDao.dropUsersTable();
//    }
//
//    public void removeUserById(long id) {
//        userDao.removeUserById(id);
//        System.out.println("Пользователь id: " + id + " удалён");
//    }
//
//    public List<User> getAllUsers() {
//        List<User> allUsers = userDao.getAllUsers();
//        for (User printuser : allUsers) {
//            System.out.println(printuser);
//        }
//        return allUsers;
//    }
//
//
//    public void cleanUsersTable() {
//        userDao.cleanUsersTable();
//    }
