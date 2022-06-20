package com.example.busticketbooking;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

public class BusRVAdapter extends RecyclerView.Adapter<BusRVAdapter.ViewHolder> {
    public ArrayList<BusRVModel> BusRVModelArrayList;
    public Context context;
    int lastPos=-1;
    public BusClickInterface busClickInterface;

    public BusRVAdapter(ArrayList<BusRVModel> BusRVModelArrayList, Context context, BusClickInterface busClickInterface) {
        this.BusRVModelArrayList = BusRVModelArrayList;
        this.context = context;
        this.busClickInterface = busClickInterface;
    }

    @NonNull
    @Override
    public BusRVAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.bus_rv_item,parent,false);
        return  new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BusRVAdapter.ViewHolder holder,int position) {
        BusRVModel busRVModel=BusRVModelArrayList.get(position);
        holder.srcTV.setText("From: "+busRVModel.getSrc());
        holder.destTV.setText("To: "+busRVModel.getDest());
        setAnimation(holder.itemView,position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                busClickInterface.onBusClick(holder.getAdapterPosition());
            }
        });
    }

    private void setAnimation(View itemView, int position) {
        if(position>lastPos){
            Animation animation= AnimationUtils.loadAnimation(context,android.R.anim.slide_in_left);
            itemView.setAnimation(animation);
            lastPos=position;
        }
    }

    public interface BusClickInterface{
        void onBusClick(int position);
    }
    @Override
    public int getItemCount() {
        return BusRVModelArrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView srcTV,destTV;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            srcTV=itemView.findViewById(R.id.idBusSrc);
            destTV=itemView.findViewById(R.id.idBusDest);
        }
    }

}
