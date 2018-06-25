package com.sayeedul.recyclerlogin;

import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.myViewHolder>{


    Context context;
    List<ItemData> myList;

    public MyAdapter(Context context, List<ItemData> myList) {
        this.context = context;
        this.myList = myList;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.recycler_layout,parent,false);
        myViewHolder myviewholder = new myViewHolder(view);
        return myviewholder;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {

        ItemData itemData = myList.get(position);

        holder.Title.setText(itemData.getTitle());
        holder.Values.setText(itemData.getValue());
        holder.imageView.setImageDrawable(context.getDrawable(itemData.getImage()));

    }

    @Override
    public int getItemCount() {
        return myList.size();
    }

    class myViewHolder extends RecyclerView.ViewHolder
    {
        ImageView imageView;
        TextView Title,Values;

        public myViewHolder(View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            Title = itemView.findViewById(R.id.textViewTitle);
            Values = itemView.findViewById(R.id.valueET);
        }
    }

}
