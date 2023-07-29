package com.example.newanimals.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newanimals.R;
import com.example.newanimals.utils.TextHelper;

public class CategoryForWorkAdapter extends RecyclerView.Adapter<CategoryForWorkAdapter.LabelHolder> {
    private Context context;

    public CategoryForWorkAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public CategoryForWorkAdapter.LabelHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.category_item, parent, false);
        return new LabelHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryForWorkAdapter.LabelHolder holder, int position) {
        holder.nameCategory.setText(TextHelper.category_for_work[position]);
    }

    @Override
    public int getItemCount() {
        return TextHelper.category_for_work.length;
    }

    public class LabelHolder extends RecyclerView.ViewHolder {
        TextView nameCategory;
        public LabelHolder(@NonNull View itemView) {
            super(itemView);
            nameCategory = itemView.findViewById(R.id.name);
        }
    }
}
