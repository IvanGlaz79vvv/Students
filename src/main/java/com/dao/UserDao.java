package com.dao;

import com.model.User;
import jm.task.core.jdbc.model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {
    void createUsersTable() throws SQLException;

    void dropUsersTable() throws SQLException;

    void saveUser(String name, String lastName, byte age);

    void removeUserById(long id);
    List<User> getAllUsers();
    void cleanUsersTable();
}
