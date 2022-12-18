package com.service;

import com.dao.UserDaoJDBCImpl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface UserService {

    void createUsersTable() throws SQLException;

    public void saveStudent(String FIO, int ball, String lesson) throws SQLException;

    public void saveLesson(String lesson, int lesson_id, String mark) throws SQLException, IOException;

//    void dropUsersTable() throws SQLException;

//    void removeUserById(long id);
//
//    List<User> getAllUsers();
//
//    void cleanUsersTable();
}