package com.example.se150296_pe2023.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.se150296_pe2023.MainActivity;
import com.example.se150296_pe2023.R;
import com.example.se150296_pe2023.api.NhanVienRepository;
import com.example.se150296_pe2023.api.NhanVienService;
import com.example.se150296_pe2023.models.Nhanvien;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditActivity extends AppCompatActivity implements View.OnClickListener {
    NhanVienService nhanvienService;
    EditText etName, etDate, etSalary, etGender;
    Button btnSave;
    long traineeID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_activity);

        etName = (EditText) findViewById(R.id.editTextName);
        etDate = (EditText) findViewById(R.id.editTextDate);
        etSalary = (EditText) findViewById(R.id.editTextSalary);
        etGender = (EditText) findViewById(R.id.editTextGender);
        btnSave = (Button) findViewById(R.id.buttonSave);

        btnSave.setOnClickListener(this);
        nhanvienService = NhanVienRepository.getTraineeService();

        Intent intent = getIntent();
        if (intent != null) {
            btnSave.setText("Cập nhật");
            traineeID = intent.getLongExtra("traineeID", -1);
//            Toast.makeText(this, traineeID+"", Toast.LENGTH_SHORT).show();
            Call<Nhanvien> call = nhanvienService.getNhanVienById(traineeID);
            call.enqueue(new Callback<Nhanvien>() {
                @Override
                public void onResponse(Call<Nhanvien> call, Response<Nhanvien> response) {
                    Nhanvien traineeData = response.body();
                    if (traineeData == null) {
                        return;
                    }
                    etName.setText(traineeData.getName());
                    etDate.setText(traineeData.getDate());
                    etSalary.setText(traineeData.getSalary());
                    etGender.setText(traineeData.getGender());
                }

                @Override
                public void onFailure(Call<Nhanvien> call, Throwable t) {
                    Toast.makeText(EditActivity.this, "Co Loi", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    private void save() {
        String name = etName.getText().toString();
        String email = etDate.getText().toString();
        String phone = etSalary.getText().toString();
        String gender = etGender.getText().toString();

        Nhanvien trainee = new Nhanvien(name, email, phone, gender);
        try {
            Call<Nhanvien> call = nhanvienService.updateNhanVien(traineeID, trainee);
            call.enqueue(new Callback<Nhanvien>() {
                @Override
                public void onResponse(Call<Nhanvien> call, Response<Nhanvien> response) {
                    if (response.body() != null) {
                        Intent intent = new Intent(EditActivity.this, MainActivity.class);
                        intent.putExtra("success_msg", true);
                        startActivity(intent);
                    } else {
                        Toast.makeText(EditActivity.this, "Please input all field!", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<Nhanvien> call, Throwable t) {
                    Toast.makeText(EditActivity.this, "Save fail!", Toast.LENGTH_SHORT).show();
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
