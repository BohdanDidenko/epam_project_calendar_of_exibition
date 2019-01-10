package com.calendarofexibition.persistence.implementation;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FactoryConnection {
    private final static Logger logger = Logger.getLogger(FactoryConnection.class);
    private final String errorMassage = "File db.properties doesn't exist ";
    private final String path = "src/main/resources/db.properties";
    private static FactoryConnection instance;
    private String host = "jdbc:mysql://localhost:3306/calendarofexposition?useSSL=true";
    private String username = "root";
    private String password = "root";

    public static FactoryConnection getInstance() {
        if (instance == null) {
            instance = new FactoryConnection();
        }
        return instance;
    }

    public FactoryConnection() {
    }

    public Connection getConnection() {

//                ResourceBundle resourceBundle = ResourceBundle.getBundle("main.resources.res");
//                host = resourceBundle.getString("db.host");
//                username = resourceBundle.getString("db.login");
//                password = resourceBundle.getString("db.password");
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver ());
            return DriverManager.getConnection(host, username, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
