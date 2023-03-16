package com.example.feedbackmanagementsystem.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.feedbackmanagementsystem.MainActivity;
import com.example.feedbackmanagementsystem.R;
import com.example.feedbackmanagementsystem.api.TraineeRepository;
import com.example.feedbackmanagementsystem.api.TraineeService;
import com.example.feedbackmanagementsystem.models.Trainee;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddActivity extends AppCompatActivity implements View.OnClickListener{
    TraineeService traineeService;
    EditText etName, etEmail, etPhone, etGender;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_activity);

        etName = (EditText) findViewById(R.id.editTextName);
        etEmail = (EditText) findViewById(R.id.editTextEmail);
        etPhone = (EditText) findViewById(R.id.editTextPhone);
        etGender = (EditText) findViewById(R.id.editTextGender);
        btnSave = (Button) findViewById(R.id.buttonSave);

        btnSave.setOnClickListener(this);
        traineeService = TraineeRepository.getTraineeService();
    }

    private void save() {
        String name = etName.getText().toString();
        String email = etEmail.getText().toString();
        String phone = etPhone.getText().toString();
        String gender = etGender.getText().toString();

        Trainee trainee = new Trainee(name, email, phone, gender);
        try {
            Call<Trainee> call = traineeService.createTrainees(trainee);
            call.enqueue(new Callback<Trainee>() {
                @Override
                public void onResponse(Call<Trainee> call, Response<Trainee> response) {
                    if (response.body() != null) {
                        Intent intent=new Intent(AddActivity.this,MainActivity.class);
                        intent.putExtra("success_msg",true);
                        startActivity(intent);
                    }else {
                        Toast.makeText(AddActivity.this, "Please input all field!", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<Trainee> call, Throwable t) {
                    Toast.makeText(AddActivity.this, "Save fail!", Toast.LENGTH_SHORT).show();
                }
            });
        } catch (Exception e) {
            Log.d("Loi", e.getMessage());
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonSave:
                save();
                break;
        }
    }
}
