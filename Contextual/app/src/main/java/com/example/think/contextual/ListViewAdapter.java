package com.example.think.contextual;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class ListViewAdapter extends ArrayAdapter<String>{
    private List<String> foods = new ArrayList<>();
    private Context context;
    public ListViewAdapter(List<String> foods, Context context){
        super(context, R.layout.item_layout);
        this.foods = foods;
        this.context = context;
    }
}
