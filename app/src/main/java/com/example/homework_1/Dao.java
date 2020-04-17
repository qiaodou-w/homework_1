package com.example.homework_1;

import androidx.lifecycle.LiveData;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@androidx.room.Dao
public interface Dao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)//冲突测率，忽视
    void insert(Notes notes);
    @Query("DELETE FROM Notes_table")
    void deleteALL();
    @Query("SELECT * from Notes_table ORDER BY word ASC")
    LiveData<List<Notes>> getAlphabetizedWords();

}
