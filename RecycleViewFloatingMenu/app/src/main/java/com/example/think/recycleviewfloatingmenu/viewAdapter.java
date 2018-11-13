package com.example.think.recycleviewfloatingmenu;

import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class viewAdapter extends RecyclerView.Adapter<viewAdapter.MyViewHolder> {
    private List<Food> foods = new ArrayList<>();
    public viewAdapter(List<Food> foods){
        this.foods = foods;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.itemlayout,viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder viewHolder, int i) {
        viewHolder.text_name.setText(foods.get(i).getName());
        viewHolder.foodview.setImageResource(foods.get(i).getId());
    }


    @Override
    public int getItemCount() {
        return foods.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener{
        ImageView foodview;
        TextView text_name;
        CardView cardView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            foodview = itemView.findViewById(R.id.pic_album);
            text_name = itemView.findViewById(R.id.text_name);
            cardView = itemView.findViewById(R.id.mCardview);
            cardView.setOnCreateContextMenuListener(this);
        }

        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
            menu.add(this.getAdapterPosition(), 121, 0, "Delete this item");
            menu.add(this.getAdapterPosition(), 122, 1, "Add this to list");

        }

    }
}
