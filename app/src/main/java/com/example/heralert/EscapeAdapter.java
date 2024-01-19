package com.example.heralert;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class EscapeAdapter extends RecyclerView.Adapter<ViewHolder> {

    Context context;
    ArrayList<Escape> escapeArrayList;

    public EscapeAdapter(Context context, ArrayList<Escape> escapeArrayList) {
        this.context = context;
        this.escapeArrayList = escapeArrayList;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.escape_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Escape escape = escapeArrayList.get(position);
        holder.nameView.setText(escape.getNameEscape());
        holder.emailView.setText(escape.getEmailEscape());
        holder.imageView.setImageResource(escape.getImageEscape());
    }

    @Override
    public int getItemCount() {
        return escapeArrayList.size();
    }
}
