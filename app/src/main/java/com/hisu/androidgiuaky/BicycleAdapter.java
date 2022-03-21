package com.hisu.androidgiuaky;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class BicycleAdapter extends RecyclerView.Adapter<BicycleAdapter.BikeViewHolder> {

    public static final String INTENT_KEY = "bike";

    private List<Bicycle> bicycleList;
    private Context context;

    public BicycleAdapter(List<Bicycle> bicycleList, Context context) {
        this.bicycleList = bicycleList;
        this.context = context;
    }

    public BicycleAdapter(Context context) {
        this.context = context;
    }

    public void setAdapterData(List<Bicycle> bicycles) {
        this.bicycleList = bicycles;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public BikeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bicycle_custom_item, parent, false);
        return new BikeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BicycleAdapter.BikeViewHolder holder, int position) {
        Bicycle bicycle = bicycleList.get(position);

        holder.img.setImageResource(bicycle.getImageUrl());
        holder.name.setText(bicycle.getName());
        holder.price.setText("$ " + bicycle.getPrice());
        holder.discount.setText("$ " + bicycle.getDiscount());

        holder.parent.setOnClickListener(view -> {
            Intent intent = new Intent(context, BicycleDetailActivity.class);
            intent.putExtra(INTENT_KEY, bicycle);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return (bicycleList == null || bicycleList.isEmpty()) ? 0 : bicycleList.size();
    }

    public class BikeViewHolder extends RecyclerView.ViewHolder {

        private CardView parent;
        private ImageView img;
        private TextView name, price, discount;

        public BikeViewHolder(@NonNull View itemView) {
            super(itemView);

            parent = itemView.findViewById(R.id.bike_parent);

            img = itemView.findViewById(R.id.bike_img);
            name = itemView.findViewById(R.id.bike_name);
            price = itemView.findViewById(R.id.bike_price);
            discount = itemView.findViewById(R.id.bike_discount);
        }
    }
}