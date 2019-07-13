package com.mortalkoding.services;

import java.sql.*;

public class DatabaseService {

    private String _databasePath;

    public Connection connect() {
        Connection conn = null;

        try {
            // db parameters
            String url = "jdbc:sqlite:" + _databasePath;
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            conn.setAutoCommit(false);

            System.out.println("Connected to the database.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }// end connect

    public DatabaseService(String dbPath){
        _databasePath = dbPath;
    }

}
