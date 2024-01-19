package com.example.heralert;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TipsAdapter extends RecyclerView.Adapter<ViewHolder> {

    Context context;
    ArrayList<Tips> tipsArrayList;

    public TipsAdapter(Context context, ArrayList<Tips> tipsArrayList) {
        this.context = context;
        this.tipsArrayList = tipsArrayList;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.tips_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Tips tips = tipsArrayList.get(position);
        holder.nameView.setText(tips.getNameTips());
        holder.emailView.setText(tips.getEmailTips());
        holder.imageView.setImageResource(tips.getImageTips());
    }

    @Override
    public int getItemCount() {
        return tipsArrayList.size();
    }
}
