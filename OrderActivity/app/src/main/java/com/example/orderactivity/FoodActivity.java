package com.example.orderactivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class FoodActivity extends AppCompatActivity implements View.OnClickListener {

    ListView lvFood;
    TextView tvChoose;
    ArrayList<FoodItems> foodList;
    FoodAdapter adapter;
    Button btnBack, btnOrder;
    FoodItems foodItems;
    String choose, getDrink,getFood;
    Intent intent;

    @Override
    public void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.food_activity);

        AnhXa();

        adapter = new FoodAdapter(this, R.layout.items, foodList);
        lvFood.setAdapter(adapter);

        btnBack.setOnClickListener(this);
        btnOrder.setOnClickListener(this);

        lvFood.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                foodItems = foodList.get(position);
                choose = foodItems.getFoodName();
                tvChoose.setText(choose);
                view.setSelected(true);
            }
        });
    }

    private void AnhXa() {

        lvFood = (ListView) findViewById(R.id.listViewFood);
        btnBack = (Button) findViewById(R.id.buttonBack);
        btnOrder = (Button) findViewById(R.id.buttonOrder);
        tvChoose = (TextView) findViewById(R.id.textViewChoose);

        intent = getIntent();
        getDrink = intent.getStringExtra("drink");
        getFood=intent.getStringExtra("food");

        foodList = new ArrayList<>();

        foodList.add(new FoodItems(R.drawable.hu_tieu, "Hủ tiếu", "Hủ tiếu Sài Gòn"));
        foodList.add(new FoodItems(R.drawable.bun_bo, "Bún bò", "Bún Bò Huế"));
        foodList.add(new FoodItems(R.drawable.mi_quang, "Mì quảng", "Mì quảng"));
        foodList.add(new FoodItems(R.drawable.pho, "Phở", "Phở Hà Nội"));
    }

    private void Order() {
        if (choose == null) {
            return;
        }
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("food", choose);
        intent.putExtra("drink", getDrink);
        startActivity(intent);
        finish();

    }

    private void Back() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("food", getFood);
        intent.putExtra("drink", getDrink);
        startActivity(intent);
        finish();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonBack:
                Back();
                break;
            case R.id.buttonOrder:
                Order();
                break;
        }
    }
}
