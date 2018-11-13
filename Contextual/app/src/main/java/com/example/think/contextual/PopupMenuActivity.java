package com.example.think.contextual;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;

public class PopupMenuActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_menu);
    }

    public void popup(View view) {
        PopupMenu popupMenu = new PopupMenu(this,view);
        MenuInflater menuInflater = popupMenu.getMenuInflater();
        //注意要添加这个监听器
        popupMenu.setOnMenuItemClickListener(this);
        menuInflater.inflate(R.menu.popmenu,popupMenu.getMenu());
        popupMenu.show();
    }


    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        switch(menuItem.getItemId()){
            case R.id.delete1:
                DisplayMessage("You fucking delete!!!!!!");
                break;
            case R.id.share1:
                DisplayMessage("You fucking share again!!!!");
                break;
        }
    return true;
    }
    public void DisplayMessage(String message){
        Snackbar.make(findViewById(R.id.rootview1), message,Snackbar.LENGTH_SHORT).show();
    }
}
