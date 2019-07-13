package com.mortalkoding.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Service should be used to connect to a general DB then
// have an adapter that uses the one DB specifically

public class DatabaseService {

    private String databasePath = "";

    private Connection connect() {
        Connection conn = null;

        try {
            // db parameters
            String url = "jdbc:sqlite:" + databasePath;
            // create a connection to the database
            conn = DriverManager.getConnection(url);

            System.out.println("Connection to SQLite has been established.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }// end connect

    public void simpleInsert(String tableName, String columnName, String valueName){
        String sql = "INSERT INTO " + tableName +
                "(" + columnName + ") " +
                "VALUES (" + valueName + ");";

        try {
            Connection conn = this.connect();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    } // end simpleInsert

    public DatabaseService(String dbPath){
        dbPath = databasePath;
    }

}
