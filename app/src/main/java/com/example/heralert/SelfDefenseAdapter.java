package com.example.heralert;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SelfDefenseAdapter extends RecyclerView.Adapter<ViewHolder> {

    Context context;
    ArrayList<SelfDefense> selfDefenses;

    public SelfDefenseAdapter(Context context, ArrayList<SelfDefense> selfDefenses) {
        this.context = context;
        this.selfDefenses = selfDefenses;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.view_self_defense, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SelfDefense selfDefense = selfDefenses.get(position);
        holder.nameView.setText(selfDefense.getNameSelfDefense());
        holder.imageView.setImageResource(selfDefense.getImageSelfDefense());
    }

    @Override
    public int getItemCount() {
        return selfDefenses.size();
    }
}
