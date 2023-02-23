package com.example.orderactivity;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class ReceiverActivity extends AppCompatActivity {
    private String food, drink;
    Intent getIntent, sendIntentToMain,sendIntentToFood,sendIntentToDrink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getIntent = getIntent();
        food = getIntent.getStringExtra("food");
        drink = getIntent.getStringExtra("drink");

        sendIntentToMain = new Intent(this, MainActivity.class);
        sendIntentToFood = new Intent(this, FoodActivity.class);
        sendIntentToDrink = new Intent(this, DrinkActivity.class);
        Bundle bundle = new Bundle();

        if (food != null && drink != null) {

            bundle.putString("foodFromReceiver", food);
            bundle.putString("drinkFromReceiver", drink);

            sendIntentToMain.putExtras(bundle);
            startActivity(sendIntentToMain);
            finish();
        } else if (food != null) {

            bundle.putString("foodFromReceiver", food);

            sendIntentToMain.putExtras(bundle);
            startActivity(sendIntentToMain);
            finish();
        } else if (drink != null) {

            bundle.putString("drinkFromReceiver", drink);

            sendIntentToMain.putExtras(bundle);
            startActivity(sendIntentToMain);
            finish();
        }
        else{
            startActivity(sendIntentToMain);
        }
    }
}
