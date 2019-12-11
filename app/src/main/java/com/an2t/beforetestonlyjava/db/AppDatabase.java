package com.an2t.beforetestonlyjava.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.an2t.beforetestonlyjava.User;


@Database(entities = {User.class} , version = 2)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();

}
