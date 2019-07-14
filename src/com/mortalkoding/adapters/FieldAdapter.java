package com.mortalkoding.adapters;

import java.sql.*;
import java.util.List;

// Schema
// CREATE TABLE IF NOT EXISTS 'Field'
// (
// 'ID' INTEGER PRIMARY KEY AUTOINCREMENT,
// 'Name' TEXT NOT NULL UNIQUE,
// 'Type' INT NOT NULL UNIQUE
// );

public class FieldAdapter extends MKDBAdapter {

    public FieldAdapter(){
        super();
    }

    public List selectAll(){
        String sql = "SELECT ID, Name, Type FROM Field";
        try {
            Connection conn = MKDBService.connect();

            Statement st = conn.createStatement();
            ResultSet results = st.executeQuery(sql);

            List list = resultsToArray(results);

            return list;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
