package com.example.homework_1;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;

import androidx.room.Entity;

import androidx.room.PrimaryKey;

@Entity(tableName = "Notes_table")
public class Notes {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "word")
    private String mName;
    public Notes(String name){
        this .mName = name;
    }
    public String getName(){
        return this.mName;
    }

}
