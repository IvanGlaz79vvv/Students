package com.dao;

import com.util.Util;

import java.sql.Connection;
import java.sql.SQLException;

public class UserDaoJDBCImpl implements UserDao{
    private final Connection conn = Util.getConnection();

    private static final String CREATE =
            "CREATE TABLE IF NOT EXISTS Students " +
                    "(id BIGINT PRIMARY KEY AUTO_INCREMENT, " +
                    " FIO VARCHAR(128), " +
                    "ball INT," +
                    "lesson VARCHAR(128)" +
                    "Lesson_id BIGINT" +
                    "mark VARCHAR(128)";
    private static final String DROP = "DROP TABLE IF EXISTS Students";
    private static final String DELETE = "DELETE FROM Students WHERE id = ?";

    private static final String SAVE = "INSERT INTO Students (Name, Last_Name, age) VALUES (?, ?, ?)";
    private static final String SELECTALL = "SELECT * FROM Students";
    private static final String TRUNCATE = "TRUNCATE TABLE Students";
    @Override
    public void createUsersTable() throws SQLException {

    }

    @Override
    public void dropUsersTable() throws SQLException {

    }

    @Override
    public void saveUser(String name, String lastName, byte age) {

    }

    @Override
    public void removeUserById(long id) {

    }

    @Override
    public void cleanUsersTable() {

    }
}
