package com.example.firebaseex2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.firebaseex2.databinding.ItemLayoutBinding;

import java.util.ArrayList;

public class CricketAdapter extends RecyclerView.Adapter<CricketAdapter.CricketViewHolder> {
    ArrayList<CricketModel> cricketModelArrayList;
Context context;

    public CricketAdapter(ArrayList<CricketModel> cricketModelArrayList, Context context) {
        this.cricketModelArrayList = cricketModelArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public CricketAdapter.CricketViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemLayoutBinding binding=DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),R.layout.item_layout,parent,false);
        return new CricketViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CricketAdapter.CricketViewHolder holder, int position) {
        CricketModel cricketModel=cricketModelArrayList.get(position);
        holder.itemLayoutBinding.setCricket(cricketModel);


    }

    @Override
    public int getItemCount() {
        return cricketModelArrayList.size();
    }
    class CricketViewHolder extends RecyclerView.ViewHolder{
private ItemLayoutBinding itemLayoutBinding;

        public CricketViewHolder(ItemLayoutBinding itemLayoutBinding) {
            super(itemLayoutBinding.getRoot());
            this.itemLayoutBinding=itemLayoutBinding;
            itemLayoutBinding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position =getAdapterPosition();
                }
            });
        }
        }
    }


