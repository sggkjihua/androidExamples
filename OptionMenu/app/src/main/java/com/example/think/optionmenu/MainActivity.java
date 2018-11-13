package com.example.think.optionmenu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
    private android.support.v7.widget.Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.mytoolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menubar,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.search:
                showMessage("You want to seatch something??");
                break;
            case R.id.cast:
                showMessage("Casting anything???");
                break;
            case R.id.setting:
                showMessage("Setting.....");
                break;
        }
        return true;
    }

    public void showMessage(String message){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }

    public void tosecond(View view) {
        startActivity(new Intent(MainActivity.this, OtherActivity.class));
    }

    public void to_tofloating(View view) {
        startActivity(new Intent(MainActivity.this, FloatingMenu.class));

    }
}
