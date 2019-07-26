package com.mortalkoding.adapters;

import com.mortalkoding.services.DatabaseServiceConnectionProvider;
import com.mortalkoding.data.GLOBAL_CONSTANTS;
import com.mortalkoding.data.SQL_Common;

import java.sql.*;
import java.util.List;

abstract class MKDBAdapter {

    private final DatabaseServiceConnectionProvider MKDBConnection =
            new DatabaseServiceConnectionProvider(GLOBAL_CONSTANTS.DATABASE_LOCATION);

    protected final SQL_Common SQL = new SQL_Common(getConnection());

    protected String table = "";

    protected Connection getConnection(){
        try {
            return MKDBConnection.SQLiteConnection();
        } catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    // common SQL methods

    public List selectAll(){ return SQL.selectAll(table); }

    protected MKDBAdapter(String tableName){
        table = tableName;
    }

    protected MKDBAdapter(){}
}
