package com.mortalkoding.services;

import java.sql.*;

public class DatabaseServiceConnectionProvider {

    private String _databasePath;

    public Connection SQLiteConnection() {
        Connection conn = null;

        try {
            // db parameters
            String url = "jdbc:sqlite:" + _databasePath;
            // System.out.println("URL: " + url);
            // create a connection to the database

            conn = DriverManager.getConnection(url);
            conn.setAutoCommit(false);
            System.out.println(String.format("SQLite connection established on %s.", _databasePath));

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }// end SQLiteConnection

//    public Connection MySQLConnection(){
//        // TODO Write code here to return a 'MySQL' Connection
//    }

    public DatabaseServiceConnectionProvider(String dbPath){
        _databasePath = dbPath;
    }

}
