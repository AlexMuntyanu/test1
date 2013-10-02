package com.springapp.notes.services;

import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

/**
 * Created with IntelliJ IDEA.
 * User: mun
 * Date: 02.10.13
 * Time: 22:08
 * To change this template use File | Settings | File Templates.
 */
@Service
public class UserService {

    public void addUser(String name, String password) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        Class.forName("org.h2.Driver");
        Connection connection = DriverManager.
                getConnection("jdbc:h2:~/test", "sa", "");
        String sqlToUsers = "insert into users (username, password, enabled) values (?,?,?)";
        String sqlToAuthorities = "insert into authorities (username, authority) values (?,?)";
        PreparedStatement toUsers = connection.prepareStatement(sqlToUsers);
        toUsers.setString(1,name);
        toUsers.setString(2, DigestUtils.md5DigestAsHex(password.getBytes()));
        toUsers.execute();
        toUsers = connection.prepareStatement(sqlToAuthorities);
        toUsers.setString(1,name);
        toUsers.setString(1,"ROLE_USER");
        toUsers.execute();
    }
}
