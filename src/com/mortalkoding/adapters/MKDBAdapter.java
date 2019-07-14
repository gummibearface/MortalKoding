package com.mortalkoding.adapters;

import com.mortalkoding.services.DatabaseService;
import java.sql.*;
import java.util.List;

public class MKDBAdapter {

    // private DatabaseService MKDBService = new DatabaseService("com.mortalkoding/data/db_MortalKoding.db");

    protected DatabaseService MKDBService = new DatabaseService("src/com/mortalkoding/data/db_MortalKoding.db");

    private void insertTest(String words){
        try {
            Connection conn = MKDBService.connect();
            String sql =
                    "INSERT INTO " +
                        "test(Words) " +
                    "VALUES" +
                        "(?);";
            PreparedStatement prep = conn.prepareStatement(sql);

            prep.setString(1,words);
            prep.executeUpdate();

            conn.commit();
            prep.close();
            conn.close();

        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    } // end insertTest

    private List select(String sql){
        try {
            Connection conn = MKDBService.connect();
            Statement st = conn.createStatement();
            ResultSet results = st.executeQuery(sql);

            List list = MKDBService.resultsToArray(results);

            return list;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
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
