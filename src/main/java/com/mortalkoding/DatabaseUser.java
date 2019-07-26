package com.mortalkoding;

import com.mortalkoding.adapters.FieldAdapter;
import com.mortalkoding.adapters.TestAdapter;

import java.util.List;

public class DatabaseUser {

    public static TestAdapter ta = new TestAdapter();

    public static void main(String args[]){
        ta.insertTest("hey");
        ta.insertTest("Hi");
        ta.insertTest("test");
        ta.insertTest("words");
        ta.insertTest("new stuf'f");

        List la = ta.selectAll();

        for (Object element : la ) {
            System.out.println(element.toString());
        }

    }

}
