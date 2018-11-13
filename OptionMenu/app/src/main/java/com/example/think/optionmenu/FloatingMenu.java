package com.example.think.optionmenu;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.zip.Inflater;

public class FloatingMenu extends AppCompatActivity {
    private Button bt_show;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_floating_menu);
        bt_show = findViewById(R.id.bt_display);
        registerForContextMenu(bt_show);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.floating, menu);

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.cast:
                displayMessage("Choose Cast!!!!");
                break;
            case R.id.search:
                displayMessage("Choose Search!!!!");
                break;

        }
        return true;
    }

    private void displayMessage(String message){
        Snackbar.make(findViewById(R.id.root_view), message, Snackbar.LENGTH_SHORT).show();
    }
}
