package com.example.think.iamgetextrecycle;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private int[] images = {R.drawable.pic1,R.drawable.pic3, R.drawable.pic5 ,R.drawable.pic2,R.drawable.pic4,R.drawable.pic6};
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerAdapter recyclerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclereview);
        layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerAdapter = new RecyclerAdapter(images,this);
        recyclerView.setAdapter(recyclerAdapter);
    }
}