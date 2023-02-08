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

public class DrinkActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tvChoose;
    ListView lvDrink;
    ArrayList<DrinkItems> drinkList;
    DrinkAdapter adapter;
    DrinkItems drinkItems;
    Button btnBack, btnOrder;
    String choose, getFood;
    Intent intent;

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.drink_activity);

        AnhXa();

        adapter = new DrinkAdapter(this, R.layout.items, drinkList);
        lvDrink.setAdapter(adapter);

        btnBack.setOnClickListener(this);
        btnOrder.setOnClickListener(this);

        lvDrink.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                drinkItems = drinkList.get(position);
                choose = drinkItems.getDrinkName();
                tvChoose.setText(choose);
            }
        });
    }

    private void AnhXa() {

        btnBack = (Button) findViewById(R.id.buttonBack);
        lvDrink = (ListView) findViewById(R.id.listViewDrink);
        tvChoose = (TextView) findViewById(R.id.textViewChoose);
        btnOrder = (Button) findViewById(R.id.buttonOrder);

        intent = getIntent();
        getFood = intent.getStringExtra("food");

        drinkList = new ArrayList<>();

        drinkList.add(new DrinkItems(R.drawable.heniken, "Heniken", "Heniken thường"));
        drinkList.add(new DrinkItems(R.drawable.pepsi, "Pepsi", "Pepsi thường"));
        drinkList.add(new DrinkItems(R.drawable.tiger, "Tiger", "Tiger thường"));
        drinkList.add(new DrinkItems(R.drawable.sai_gon_do, "Sài Gòn", "Sài Gòn đỏ"));


    }

    private void Order() {
        if (choose == null) {
            return;
        }
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("food", getFood);
        intent.putExtra("drink", choose);
        startActivity(intent);
        finish();
    }

    private void Back() {
        Intent intent = new Intent(this, MainActivity.class);
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
