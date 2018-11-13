package com.example.think.recycleviewfloatingmenu;

import android.media.MediaPlayer;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private int[] pic_id = {R.drawable.pic1, R.drawable.pic2, R.drawable.pic3, R.drawable.pic4, R.drawable.pic5,
    R.drawable.pic6};
    private String[] names;
    private List<Food> foods = new ArrayList<>();
    private RecyclerView recyclerView;
    private viewAdapter viewAdapter1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        names = getResources().getStringArray(R.array.food_name);
        getfood();
        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        viewAdapter1 = new viewAdapter(foods);
        recyclerView.setAdapter(viewAdapter1);
    }

    private  void getfood(){
        int count = 0;
        for(String name:names){
            Food food = new Food(pic_id[count], name);
            foods.add(food);
            count = count+1;
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case 121:
                displayMessage("Item deleted");
                return true;
            case 122:
                displayMessage("Item Added");
                return true;
        default:
            return true;
        }
    }
    private void displayMessage(String message){
        Snackbar.make(findViewById(R.id.root_view),message,Snackbar.LENGTH_SHORT).show();
    }
}
