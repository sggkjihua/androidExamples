package com.example.think.roomex;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;


@Database(entities = {User.class},version = 1,exportSchema = false)
//需要继承roomdatabase,同时要指明相应的表以及版本号，必须是abstract的
public abstract class MyDatabase extends RoomDatabase {
    public abstract MyDao myDao();

}
