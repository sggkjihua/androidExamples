package com.example.think.roomex;

import android.arch.persistence.room.Room;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    public static FragmentManager fragmentManager;
    public static MyDatabase myDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();

        //初始化数据库，默认的不让数据库占用太多时间，因此要加allowmainthread。。。。。
        myDatabase = Room.databaseBuilder(getApplicationContext(), MyDatabase.class, "userdb").allowMainThreadQueries().build();

        if(findViewById(R.id.fragment_container)!= null){
            if (savedInstanceState!=null){
                return;
            }
            HomeFragment homeFragment = new HomeFragment();
            fragmentManager.beginTransaction().add(R.id.fragment_container,homeFragment).commit();

        }
    }
}
