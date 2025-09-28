package com.example.batch4bookmanagementsystem;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Repository
public class DatabaseRepository {

    private Connection connection = null;


    String url;

    String username;

    String password;

    DatabaseRepository(@Value("${db.url}") String url,
                   @Value("${db.username}") String username
            ,@Value("${db.password}") String password) throws SQLException {
        this.url = url;
        this.username = username;
        this.password = password;
    }


    public Connection getConnection() throws SQLException {
        if(connection == null) {
            connection= DriverManager.getConnection(this.url,this.username,this.password);
        }
        return connection;
    }
}
