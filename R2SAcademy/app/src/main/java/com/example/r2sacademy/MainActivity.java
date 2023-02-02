package com.example.r2sacademy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText firstNum, secondNum;
    Button btnCong, btnTru, btnNhan, btnChia;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Anhxa();

        btnCong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String num1 = firstNum.getText().toString();
                String num2 = secondNum.getText().toString();
                if (!checkEmpty(num1, num2)) {
                    Toast.makeText(MainActivity.this, "Please in put all number!", Toast.LENGTH_SHORT).show();
                } else {
                    int soThuNhat = Integer.parseInt(num1);
                    int soThuHai = Integer.parseInt(num2);
                    int sum = soThuNhat + soThuHai;
                    result.setText(String.valueOf(sum));
                }
            }
        });
        btnTru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num1 = firstNum.getText().toString();
                String num2 = secondNum.getText().toString();
                if (!checkEmpty(num1, num2)) {
                    Toast.makeText(MainActivity.this, "Please in put all number!", Toast.LENGTH_SHORT).show();
                } else {
                    int soThuNhat = Integer.parseInt(num1);
                    int soThuHai = Integer.parseInt(num2);
                    double minus = (double) soThuNhat - soThuHai;
                    result.setText(String.valueOf(minus));
                }
            }
        });
        btnNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num1 = firstNum.getText().toString();
                String num2 = secondNum.getText().toString();
                if (!checkEmpty(num1, num2)) {
                    Toast.makeText(MainActivity.this, "Please in put all number!", Toast.LENGTH_SHORT).show();
                } else {
                    int soThuNhat = Integer.parseInt(num1);
                    int soThuHai = Integer.parseInt(num2);
                    int pow = soThuNhat * soThuHai;
                    result.setText(String.valueOf(pow));
                }
            }
        });
        btnChia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num1 = firstNum.getText().toString();
                String num2 = secondNum.getText().toString();
                if (!checkEmpty(num1, num2)) {
                    Toast.makeText(MainActivity.this, "Please in put all number!", Toast.LENGTH_SHORT).show();
                } else {
                    int soThuNhat = Integer.parseInt(num1);
                    int soThuHai = Integer.parseInt(num2);
                    double div = (double) soThuNhat / soThuHai;
                    result.setText(String.valueOf(div));
                }
            }
        });

    }

    private boolean checkEmpty(String num1, String num2) {
        if (num1.isEmpty() || num2.isEmpty()) {
            return false;
        }
        return true;
    }

    private void Anhxa() {
        firstNum = (EditText) findViewById(R.id.editTextNumber);
        secondNum = (EditText) findViewById(R.id.editTextNumber2);
        btnCong = (Button) findViewById(R.id.buttonCong);
        btnTru = (Button) findViewById(R.id.buttonTru);
        btnNhan = (Button) findViewById(R.id.buttonNhan);
        btnChia = (Button) findViewById(R.id.buttonChia);
        result = (TextView) findViewById(R.id.result);
    }
}