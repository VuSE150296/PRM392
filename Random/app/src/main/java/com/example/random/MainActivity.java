package com.example.random;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    EditText editTextMin, editTextMax;
    TextView textViewResult;
    Button btnGenerator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Anhxa();

        btnGenerator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String firstNum = editTextMin.getText().toString();
                String secondNum = editTextMax.getText().toString();
                if (firstNum.isEmpty()|| secondNum.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please input the number!", Toast.LENGTH_SHORT).show();
                } else {
                    int min = Integer.parseInt(firstNum);
                    int max = Integer.parseInt(secondNum);
                    if (max > min) {
                        Random random = new Random();
                        int number = random.nextInt(max - min + 1) + min;
                        textViewResult.setTextSize(50);
                        textViewResult.setText(String.valueOf(number));
                    } else {
                        Toast.makeText(MainActivity.this, "Please input correct!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    private void Anhxa() {
        editTextMin = (EditText) findViewById(R.id.editTextNumberMin);
        editTextMax = (EditText) findViewById(R.id.editTextNumberMax);
        textViewResult = (TextView) findViewById(R.id.textResult);
        btnGenerator = (Button) findViewById(R.id.buttonGenerator);
    }
}