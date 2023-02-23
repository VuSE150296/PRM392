package com.example.lifecycle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class Activity2 extends AppCompatActivity implements View.OnClickListener {
    Button btnChangePage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btnChangePage = (Button) findViewById(R.id.button);

        btnChangePage.setOnClickListener(this);
    }

    private void changePage(){
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:
                changePage();
                break;
        }
    }

}
