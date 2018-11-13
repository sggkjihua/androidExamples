package com.example.think.myapplication;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Main2Activity extends AppCompatActivity {
    public static FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        fragmentManager = getSupportFragmentManager();
        if(findViewById(R.id.fragment_container)!=null){
            if (savedInstanceState!=null){
                return;
            }
        }
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FirstFragment first = new FirstFragment();
        Another_fragment fg = new Another_fragment();
        fragmentTransaction.add(R.id.fragment_container, fg , null);
        fragmentTransaction.commit();
    }
}
