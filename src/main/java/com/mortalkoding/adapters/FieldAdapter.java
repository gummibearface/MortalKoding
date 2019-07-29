package com.mortalkoding.adapters;

import java.util.List;

public class FieldAdapter extends MKDBAdapter{

//////////////////////////////////////////////////
// Schema
////////////
// CREATE TABLE IF NOT EXISTS 'Field'
// (
// 'ID' INTEGER PRIMARY KEY AUTOINCREMENT,
// 'Name' TEXT NOT NULL UNIQUE,
// 'Type' INT NOT NULL UNIQUE
// );
//////////////////////////////////////////////////

// This will connect to the "Field" table

    public FieldAdapter(){
        super("Field");
    }
}
