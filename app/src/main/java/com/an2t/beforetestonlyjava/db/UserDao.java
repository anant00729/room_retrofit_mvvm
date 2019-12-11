package com.an2t.beforetestonlyjava.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.an2t.beforetestonlyjava.User;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

@Dao
public interface UserDao {

    @Insert
    public void addUser(User user);

    @Query("SELECT * FROM users")
    public List<User> getAllUsers();

    @Delete
    public int deleteUser(User user);


}
