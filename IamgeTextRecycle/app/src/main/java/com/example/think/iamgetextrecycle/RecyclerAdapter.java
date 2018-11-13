package com.example.think.iamgetextrecycle;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ImageViewHolder> {
    private Context context;
    private int[] images;
    public RecyclerAdapter(int[] images, Context context){
        this.images =images;
        this.context=context;
    }
    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.album_layout,viewGroup,false);
        ImageViewHolder imageViewHolder = new ImageViewHolder(view,context,images);

        return imageViewHolder ;
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder viewHolder, int i) {
        //设置好这个holder的位置信息以及获取其内容
        int image_id = images[i];
        viewHolder.Album.setImageResource(image_id);
        viewHolder.AlbumnTitle.setText("Image :"+i);
    }

    @Override
    public int getItemCount() {
        //自动帮我们计算好要列出来的长度
        return images.length;
    }

    public static class ImageViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView Album;
        TextView AlbumnTitle;
        Context context;
        int[] images;
        public ImageViewHolder(@NonNull View itemView, Context context, int[] images) {
            super(itemView);
            Album = itemView.findViewById(R.id.albumn);
            AlbumnTitle = itemView.findViewById(R.id.albumn_title);
            itemView.setOnClickListener(this);
            this.context = context;
            this.images = images;
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(context,DisplayActivity.class);
            //获取当前选中的图
            intent.putExtra("image_id", images[getAdapterPosition()]);
            context.startActivity(intent);
        }
    }
}
