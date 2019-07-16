package com.mortalkoding.data;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SQL_Common {

    private Connection _localConnection = null;

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

    public List selectAll(String tableName){
        String sql = String.format("SELECT * FROM %s",tableName);
        try {
            Connection conn = _localConnection;
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            List rl = resultsToArray(rs);

            st.close();
            conn.close();
            return rl;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public SQL_Common (Connection connection){
        _localConnection = connection;
    }
}
