package com.example.orderactivity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnOrderFood, btnOrderDrink, btnExit;
    AlertDialog.Builder builder;
    TextView tvFood, tvDrink;
    String food, drink;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnhXa();

        setFood();
        setDrink();

        btnOrderFood.setOnClickListener(this);
        btnOrderDrink.setOnClickListener(this);
        btnExit.setOnClickListener(this);
    }

    private void AnhXa() {
        btnOrderFood = (Button) findViewById(R.id.buttonFood);
        btnOrderDrink = (Button) findViewById(R.id.buttonDrink);
        btnExit = (Button) findViewById(R.id.buttonExit);
        tvFood = (TextView) findViewById(R.id.textViewFood);
        tvDrink = (TextView) findViewById(R.id.textViewDrink);

        builder = new AlertDialog.Builder(this);

        intent = getIntent();
    }

    private void orderFood() {
        Intent intent = new Intent(this, FoodActivity.class);
        intent.putExtra("drink", drink);
        startActivity(intent);
        finish();
    }

    private void orderDrink() {
        Intent intent = new Intent(this, DrinkActivity.class);
        intent.putExtra("food", food);
        startActivity(intent);
        finish();
    }

    private void exit() {
        builder.setMessage("Bạn có muốn thoát App không?").setCancelable(false).setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
                System.exit(0);
            }
        }).setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
                Toast.makeText(MainActivity.this, "Đã hủy!", Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    private void setFood() {
        food = intent.getStringExtra("food");

        if (food != null) {
            tvFood.setText(food);
        }
    }

    private void setDrink() {
        drink = intent.getStringExtra("drink");

        if (drink != null) {
            tvDrink.setText(drink);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonFood:
                orderFood();
                break;
            case R.id.buttonDrink:
                orderDrink();
                break;
            case R.id.buttonExit:
                exit();
                break;
        }
    }
}