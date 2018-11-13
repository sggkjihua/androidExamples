package com.example.think.roomex;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
import android.support.annotation.RequiresPermission;

import java.util.List;

@Dao
public interface MyDao {
    //进行增删改操作
    @Insert
    public void addUser(User user);

    @Delete
    public void deleteUser(User user);

    @Update
    public void updateUser(User user);

    @Query("Select * from users")
    public List<User> getUsers();
}
