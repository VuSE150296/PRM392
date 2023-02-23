package com.example.senddata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tvString, tvNumber, tvArray, tvSerializable;
    Button btnSendData, btnChangeActivity;
    Intent intent;
    String string = "This is String Data send by bundle";
    Integer number = 12;
    String[] array = {"Sai Gon", "Ha Noi", "Da Nang", "Can Tho"};
    Student student = new Student("Tran Van Tam", 2000);
    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnhXa();

        bundle = new Bundle();

        intent = getIntent();
        String getString = intent.getStringExtra("string");
        Integer getNumber = intent.getIntExtra("number", 123);
        String[] getArray = intent.getStringArrayExtra("array");

        Student getStudent = (Student) intent.getSerializableExtra("student");

        tvString.setText("String: " + getString);
        tvNumber.setText("Number" + getNumber);

        //Chuyển đổi nội dung của mảng thành chuỗi
        String arrayReceive = Arrays.toString(getArray);
        tvArray.setText("Array: " + arrayReceive);

        if (getStudent != null) {
            tvSerializable.setText("Student: " + getStudent.getName() + " - " + getStudent.getYear());
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

        intent = new Intent(this, SecondActivity.class);
        bundle.putString("string", string);
        bundle.putInt("number", number);
        bundle.putStringArray("array", array);
        bundle.putSerializable("student", student);

        intent.putExtra("Bundle", bundle);

        startActivity(intent);
    }

    private void changeActivity() {
        intent = new Intent(this, SecondActivity.class);
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