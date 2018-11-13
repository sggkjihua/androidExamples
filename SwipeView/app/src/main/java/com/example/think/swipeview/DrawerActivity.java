package com.example.think.swipeview;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class DrawerActivity extends AppCompatActivity implements View.OnClickListener {
    private android.support.v7.widget.Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);
        toolbar = findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);

        final ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);


        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.person:
                        menuItem.setChecked(true);
                        display("Go to the person account!!");
                        drawerLayout.closeDrawers();
                        return true;

                    case R.id.camera:
                        menuItem.setChecked(true);
                        display("Using the camera here!!!");
                        drawerLayout.closeDrawers();
                        displayPopup();
                        return true;
                    case R.id.bluetooth:
                        menuItem.setChecked(true);
                        display("Connecting to others!!!");
                        drawerLayout.closeDrawers();
                        return true;
                }
                return false;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void display(String message){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }

    public void displayPopup(){
        Snackbar snackbar = Snackbar.make(findViewById(R.id.drawer_layout), R.string.offline_message,Snackbar.LENGTH_SHORT);
        snackbar.show();
        snackbar.setAction("Out",this);
    }

    @Override
    public void onClick(View v) {
        startActivity(new Intent(this,MainActivity.class));
    }
}
