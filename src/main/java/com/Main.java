package com;

import com.service.UserService;
import com.service.UserServiceImpl;

import java.io.IOException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, IOException {
        System.out.println("\nHello world!");

        UserServiceImpl userServiceImpl = new UserServiceImpl();
//
//        userServiceImpl.createUsersTable();
//
        userServiceImpl.saveStudent();

//        userServiceImpl.getUser();

        System.exit(0);
    }

}