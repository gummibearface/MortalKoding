package com.mortalkoding.adapters;

import com.mortalkoding.services.DatabaseService;
import java.sql.*;

public class MKDBAdapter {

    // private DatabaseService MKDBService = new DatabaseService("com.mortalkoding/data/db_MortalKoding.db");

    private static DatabaseService MKDBService = new DatabaseService("src/com/mortalkoding/data/db_MortalKoding.db");

    public static void insertTest(String words){
        Connection conn = null;
        try {
            conn = MKDBService.connect();

            PreparedStatement prep = conn.prepareStatement("INSERT INTO test(Words) VALUES(?);");

            prep.setString(1,words);
            prep.executeUpdate();

            conn.commit();
            prep.close();
            conn.close();

        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void main (String args[]){
        insertTest("new't");
    }


}
