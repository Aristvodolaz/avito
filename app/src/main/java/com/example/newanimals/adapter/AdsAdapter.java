package com.example.newanimals.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newanimals.R;
import com.example.newanimals.db.AdsData;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdsAdapter extends RecyclerView.Adapter<AdsAdapter.LabelHolder> {
    public List<AdsData> data;
    public Context context;

    public AdsAdapter(List<AdsData> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public AdsAdapter.LabelHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.ads_item, parent, false);
        return new LabelHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AdsAdapter.LabelHolder holder, int position) {
        holder.name.setText(data.get(position).getName());
        holder.price.setText(data.get(position).getPrice());
        holder.date.setText(data.get(position).getDate());
        holder.address.setText(data.get(position).getAddress());
        Picasso.get().load(data.get(position).getImg()).into(holder.image);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class LabelHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView name,price, address, date;


        public LabelHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.img);
            name = itemView.findViewById(R.id.name);
            price = itemView.findViewById(R.id.price);
            address = itemView.findViewById(R.id.address);
            date = itemView.findViewById(R.id.date_publish);
        }
    }
}
