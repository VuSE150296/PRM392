package com.example.orderactivity;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class ReceiverActivity extends AppCompatActivity {
    private String food, drink;
    Intent getIntent, sendIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getIntent = getIntent();
        food = getIntent.getStringExtra("food");
        drink = getIntent.getStringExtra("drink");

        sendIntent = new Intent(this, MainActivity.class);
        Bundle bundle = new Bundle();

        if (food != null && drink != null) {

            bundle.putString("foodFromReceiver", food);
            bundle.putString("drinkFromReceiver", drink);

            sendIntent.putExtras(bundle);
            startActivity(sendIntent);
            finish();
        } else if (food != null) {

            bundle.putString("foodFromReceiver", food);

            sendIntent.putExtras(bundle);
            startActivity(sendIntent);
            finish();
        } else if (drink != null) {

            bundle.putString("drinkFromReceiver", drink);

            sendIntent.putExtras(bundle);
            startActivity(sendIntent);
            finish();
        }
    }
}
