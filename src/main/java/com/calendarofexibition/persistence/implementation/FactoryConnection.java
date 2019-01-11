package com.calendarofexibition.persistence.implementation;

import org.apache.log4j.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FactoryConnection {
    private static volatile FactoryConnection instance;
    private final static Logger logger = Logger.getLogger(FactoryConnection.class);
    private final String errorMassage = "File db.properties doesn't exist ";
    private final String path = "src/main/resources/db.properties";
    private String host = "jdbc:mysql://localhost:3306/calendarofexposition?serverTimezone=UTC";
    private String username = "root";
    private String password = "root";

    private FactoryConnection() {
    }

    public static FactoryConnection getInstance() {
        if (instance == null) {
            synchronized (FactoryConnection.class){
                if (instance == null) {
                    instance = new FactoryConnection();
                }
            }
        }
        return instance;
    }

    public Connection getConnection() {
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver ());
            /*
            BasicDataSource ds = new BasicDataSource();

            ResourceBundle resource = ResourceBundle.getBundle("db");

            ds.setDriverClassName(resource.getString("driver"));
            ds.setUrl(resource.getString("url"));
            ds.setUsername(resource.getString("user"));
            ds.setPassword(resource.getString("pass"));
            ds.setMinIdle(Integer.valueOf(resource.getString("min")));
            ds.setMaxIdle(Integer.valueOf(resource.getString("max")));
            ds.setMaxOpenPreparedStatements(Integer.valueOf(resource.getString("statements")));
            dataSource = ds */
            return DriverManager.getConnection(host, username, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
