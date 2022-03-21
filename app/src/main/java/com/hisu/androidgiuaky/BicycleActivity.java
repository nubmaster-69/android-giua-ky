package com.hisu.androidgiuaky;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class BicycleActivity extends AppCompatActivity implements View.OnClickListener {

    private BicycleAdapter bicycleAdapter;
    private RecyclerView mRecyclerView;

    private List<Bicycle> bicycleList;
    private List<Bicycle> filteredList;

    private Button[] buttons = null;
    private Button btnTrend, btnPop, btnRecom, prevFocusBtn;

    @RequiresApi(api = Build.VERSION_CODES.R)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bicycle);

        initUI();

        bicycleAdapter = new BicycleAdapter(this);
        bicycleAdapter.setAdapterData(bicycleList);
        mRecyclerView.setAdapter(bicycleAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));

        for (int i = 0; i < buttons.length; i++) {
            buttons[i].setOnClickListener(this);
        }
        prevFocusBtn = buttons[0];
    }

    @RequiresApi(api = Build.VERSION_CODES.R)
    private void initUI() {

        mRecyclerView = findViewById(R.id.my_recycler_view);

        btnTrend = findViewById(R.id.btn_trending);
        btnPop = findViewById(R.id.btn_popular);
        btnRecom = findViewById(R.id.btn_recommend);

        buttons = new Button[]{ btnTrend, btnPop, btnRecom };

        filteredList = new ArrayList<>();

        //int imageUrl, String name, String desc, double price, double discount, double discountPercentage
        bicycleList = List.of(
                new Bicycle(R.drawable.bione_removebg_preview, "Red Bull One",
                        "It is a very important form of writing as we write almost everything in paragraphs, be it an answer, essay, story, emails, etc.",
                        350, 449, 15, 0),
                new Bicycle(R.drawable.bifour_removebg_preview, "Blue One",
                        "It is a very important form of writing as we write almost everything in paragraphs, be it an answer, essay, story, emails, etc.",
                        840, 959, 15, 0),
                new Bicycle(R.drawable.bifour_removebg_preview, "Blue One",
                        "It is a very important form of writing as we write almost everything in paragraphs, be it an answer, essay, story, emails, etc.",
                        840, 959, 15, 1),
                new Bicycle(R.drawable.bifour_removebg_preview, "Blue One",
                        "It is a very important form of writing as we write almost everything in paragraphs, be it an answer, essay, story, emails, etc.",
                        840, 959, 15, 2)
        );
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.btn_trending: {
                switchButtonFocusState(prevFocusBtn, btnTrend, 0);
                break;
            }

            case R.id.btn_popular: {
                switchButtonFocusState(prevFocusBtn, btnPop, 1);
                break;
            }

            case R.id.btn_recommend: {
                switchButtonFocusState(prevFocusBtn, btnRecom, 2);
                break;
            }
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void switchButtonFocusState(Button prevBtn, Button clickBtn, int type) {

        this.prevFocusBtn.setBackgroundColor(Color.WHITE);
        clickBtn.setBackgroundColor(Color.rgb(250,255,255));

        filteredList.clear();

        bicycleList.forEach(bicycle -> {
            if(bicycle.getType() == type)
                filteredList.add(bicycle);
        });

        this.prevFocusBtn = clickBtn;

        bicycleAdapter.setAdapterData(filteredList);
    }
}