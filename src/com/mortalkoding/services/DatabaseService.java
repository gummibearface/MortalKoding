package com.mortalkoding.services;

import java.sql.*;

public class DatabaseService {

    private String _databasePath;

    public Connection SQLiteConnection() {
        Connection conn = null;

        try {
            // db parameters
            String url = "jdbc:sqlite:" + _databasePath;
            System.out.println("URL: " + url);
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            conn.setAutoCommit(false);
            System.out.println("Connected to  DB.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }// end SQLiteConnection

//    public Connection MySQLConnection(){
//        // Write code here to return a 'MySQL' Connection
//    }

    public DatabaseService(String dbPath){
        _databasePath = dbPath;
    }

}
