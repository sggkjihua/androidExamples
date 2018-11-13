package com.example.think.recycleex;

import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {
    //自己写的adaoter用于处理每个item的相应位置
    private List<String> list;

    public RecyclerAdapter(List<String> list){
        this.list = list;

    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //用于创建每个item
        TextView textView = (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.text_view, viewGroup,false);
        MyViewHolder myViewHolder = new MyViewHolder(textView);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder viewHolder, int i) {
        viewHolder.VersionName.setText(list.get(i));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView VersionName;
        public MyViewHolder(@NonNull TextView itemView) {
            super(itemView);
            VersionName = itemView;
        }
    }

    public void updateList(List<String> newList){
        list = new ArrayList<>();
        list.addAll(newList);
        notifyDataSetChanged();
    }
}
