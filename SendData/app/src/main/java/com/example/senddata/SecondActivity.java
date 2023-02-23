package com.example.senddata;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Arrays;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {
    TextView tvString, tvNumber, tvArray, tvSerializable;
    Button btnSendData, btnChangeActivity;
    Intent intent;
    String string = "This is String Data";
    Integer number = 12;
    String[] array = {"Android", "IOS", "PHP", "NodeJS", "Unity"};
    Student student = new Student("Nguyen Van An", 2000);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        AnhXa();
        intent = getIntent();
        Bundle bundle = intent.getBundleExtra("Bundle");

        if (bundle != null) {
            String getSting = bundle.getString("string");
            Number getNumber = bundle.getInt("number", 123);
            String[] getArray = bundle.getStringArray("array");
            Student getStudent = (Student) bundle.getSerializable("student");

            String arrayReceiver = Arrays.toString(getArray);

            tvString.setText("String: " + getSting);
            tvNumber.setText("Number: " + getNumber);
            tvArray.setText("Array: " + arrayReceiver);
            tvSerializable.setText("Serializable: " + getStudent.getName() + " - " + getStudent.getYear());
        }
        btnSendData.setOnClickListener(this);
        btnChangeActivity.setOnClickListener(this);
    }

    private void AnhXa() {
        tvString = (TextView) findViewById(R.id.textViewString);
        tvNumber = (TextView) findViewById(R.id.textViewNumber);
        tvArray = (TextView) findViewById(R.id.textViewArray);
        tvSerializable = (TextView) findViewById(R.id.textViewSerializable);
        btnSendData = (Button) findViewById(R.id.buttonSend);
        btnChangeActivity = (Button) findViewById(R.id.buttonChangeActivity);
    }

    private void sendData() {

        intent = new Intent(this, MainActivity.class);
        intent.putExtra("string", string);
        intent.putExtra("number", number);
        intent.putExtra("array", array);
        intent.putExtra("student", student);
        startActivity(intent);
    }

    private void changeActivity() {
        intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonSend:
                sendData();
                break;
            case R.id.buttonChangeActivity:
                changeActivity();
                break;
        }
    }
}
