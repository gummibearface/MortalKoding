package com.mortalkoding.adapters;

import com.mortalkoding.services.DatabaseService;
import com.mortalkoding.data.GLOBAL_CONSTANTS;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

abstract class MKDBAdapter {

    protected DatabaseService MKDBService = new DatabaseService(GLOBAL_CONSTANTS.DATABASE_LOCATION);

    protected List resultsToArray (ResultSet results) throws SQLException {
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

    protected MKDBAdapter(){

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
