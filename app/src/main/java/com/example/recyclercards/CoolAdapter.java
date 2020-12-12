package com.example.recyclercards;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CoolAdapter extends RecyclerView.Adapter<CoolAdapter.CoolViewHolder> {

    private ArrayList<Coolitems>mCoolList;

    public static class CoolViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView textView;

        public CoolViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.textView);
        }


    }

    public CoolAdapter(ArrayList<Coolitems> coolList) {
        mCoolList = coolList;
    }



    @NonNull
    @Override
    public CoolViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //return null;

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_cool_items,parent,false);
        CoolViewHolder coolViewHolder = new CoolViewHolder(view);
        return coolViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CoolViewHolder coolViewHolder, int position) {

        Coolitems currentItem = mCoolList.get(position);
        coolViewHolder.imageView.setImageResource(currentItem.getmImageResource());
        coolViewHolder.textView.setText(currentItem.getmText());


    }

    @Override
    public int getItemCount() {
        return mCoolList.size();
    }



}
