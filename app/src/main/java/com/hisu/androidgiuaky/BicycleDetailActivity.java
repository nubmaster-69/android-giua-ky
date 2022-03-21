package com.hisu.androidgiuaky;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class BicycleDetailActivity extends AppCompatActivity {

    private ImageView img;
    private TextView name, discount, price, desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bicycle_detail);

        initUi();

        Bicycle bicycle = (Bicycle) getIntent().getSerializableExtra(BicycleAdapter.INTENT_KEY);

        img.setImageResource(bicycle.getImageUrl());
        name.setText(bicycle.getName());
        discount.setText(bicycle.getDiscountPercentage() + "% OFF | " + bicycle.getPrice() + "$");
        price.setText(bicycle.getDiscount() + "$");
        desc.setText(bicycle.getDesc());
    }

    private void initUi() {
        img = findViewById(R.id.bike_detail_img);
        name = findViewById(R.id.bike_detail_name);
        discount = findViewById(R.id.bike_detail_discount);
        price = findViewById(R.id.bike_detail_price);
        desc = findViewById(R.id.bike_detail_desc);
    }
}