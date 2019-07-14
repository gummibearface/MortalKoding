package com.mortalkoding.adapters;

import com.mortalkoding.services.DatabaseService;
import com.mortalkoding.data.GLOBAL_CONSTANTS;
import com.mortalkoding.data.SQL_Common;

import java.sql.*;

abstract class MKDBAdapter {

    private final DatabaseService MKDBService =
            new DatabaseService(GLOBAL_CONSTANTS.DATABASE_LOCATION);

    protected final SQL_Common SQL = new SQL_Common(getConnection());

    protected Connection getConnection(){
        try {
            return MKDBService.SQLiteConnection();
        } catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

//    private void insertTest(String words){
//        try {
//            Connection conn = MKDBService.connect();
//            String sql =
//                    "INSERT INTO " +
//                        "test(Words) " +
//                    "VALUES" +
//                        "(?);";
//            PreparedStatement prep = conn.prepareStatement(sql);
//
//            prep.setString(1,words);
//            prep.executeUpdate();
//
//            conn.commit();
//            prep.close();
//            conn.close();
//
//        } catch (Exception e){
//            System.out.println(e.getMessage());
//        }
//    } // end insertTest
//
//    private List select(String sql){
//        try {
//            Connection conn = MKDBService.connect();
//            Statement st = conn.createStatement();
//            ResultSet results = st.executeQuery(sql);
//
//            List list = MKDBService.resultsToArray(results);
//
//            return list;
//
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//        return null;
//    }
//
//    public static void main (String args[]){
//        try {
//            List list = selectTest();
//
//            list.forEach(item->System.out.println(item));
//
//        }
//        catch (Exception e){
//            System.out.println(e.getMessage());
//        }
//    }
}
