package com.mortalkoding.adapters;

import java.sql.*;
import java.util.List;

public class TestAdapter extends MKDBAdapter {

    public TestAdapter(){
        super("Test");
    }

    public void insertTest(String words){
        try {
            Connection conn = getConnection();
            String sql =
                    "INSERT INTO " +
                        "Test(Words) " +
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
}
