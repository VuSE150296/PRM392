package com.example.lifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnChangePage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnChangePage = (Button) findViewById(R.id.button);

        btnChangePage.setOnClickListener(this);
        Log.d("AAA", "onCreate Main");
    }

    private void changePage() {
        Intent intent = new Intent(this, Activity2.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("AAA", "onStart second");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("AAA", "onStop second");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("AAA", "onPause second");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("AAA", "onResume second");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("AAA", "onRestart second");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                changePage();
                break;
        }
    }
}