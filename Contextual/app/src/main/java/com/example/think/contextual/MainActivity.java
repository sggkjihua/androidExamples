package com.example.think.contextual;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.design.widget.SnackbarContentLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.concurrent.PriorityBlockingQueue;

public class MainActivity extends AppCompatActivity {
    private Button button;

    private ActionMode actionMode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.showContextual);
        button.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (actionMode!=null){
                    return false;
                }
                actionMode = startActionMode(mActionModeCallBack);
                return true;
            }
        });
    }
    private ActionMode.Callback mActionModeCallBack = new ActionMode.Callback() {
        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            MenuInflater menuInflater = mode.getMenuInflater();
            menuInflater.inflate(R.menu.mymenu,menu);
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            switch (item.getItemId()){
                case R.id.delete:
                    displayMEssage("You fucking click the delete button");
                    break;
                case R.id.share:
                    displayMEssage("Why did you click the share button????");
                    break;
                    default:
                        displayMEssage("You did nothing up to now");
                        break;
            }
            return true;
        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {
            actionMode = null;
        }
    };

    private void displayMEssage(String message){
        Snackbar.make(findViewById(R.id.rootview),message ,Snackbar.LENGTH_SHORT ).show();
    }

    public void popupmenu(View view) {
        startActivity(new Intent(this,PopupMenuActivity.class));
    }
}
