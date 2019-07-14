package com.mortalkoding.services;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DatabaseService {

    private String _databasePath;

    public List resultsToArray (ResultSet results) throws SQLException {
        ResultSetMetaData md = results.getMetaData();

        int columns = md.getColumnCount();
        ArrayList list = new ArrayList();
        while (results.next()){
            HashMap row = new HashMap(columns);
            for (int i = 1; i <= columns; ++i){
                row.put(md.getColumnName(i), results.getObject(i));
            }
            list.add(row);
        }
        return list;
    }

    public Connection connect() {
        Connection conn = null;

        try {
            // db parameters
            String url = "jdbc:sqlite:" + _databasePath;
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            conn.setAutoCommit(false);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }// end connect

    public DatabaseService(String dbPath){
        _databasePath = dbPath;
    }

}
