package com.example.think.swipeview;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewpager;
    private DemoFragmentAdapter demoFragmentAdapter;
    private TabLayout tabLayout;
    private android.support.v7.widget.Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewpager = findViewById(R.id.pager);
        demoFragmentAdapter = new DemoFragmentAdapter(getSupportFragmentManager());
        viewpager.setAdapter(demoFragmentAdapter);
        toolbar = findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewpager);
    }

    public void todrawer(View view) {
        startActivity(new Intent(this, DrawerActivity.class));
    }
}
