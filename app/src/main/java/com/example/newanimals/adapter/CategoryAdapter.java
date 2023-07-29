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

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.LabelHolder> {

   String[] data = TextHelper.category;
   Context context;

    public CategoryAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public CategoryAdapter.LabelHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.category_item, parent, false);
        return new LabelHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.LabelHolder holder, int position) {
        holder.nameCategory.setText(data[position]);

    }

    @Override
    public int getItemCount() {
        return  TextHelper.category.length;
    }

    public class LabelHolder extends RecyclerView.ViewHolder {
        TextView nameCategory;
        public LabelHolder(@NonNull View itemView) {
            super(itemView);
            nameCategory = itemView.findViewById(R.id.name);
        }
    }
}
