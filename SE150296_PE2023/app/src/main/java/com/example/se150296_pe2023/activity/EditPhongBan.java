package com.example.se150296_pe2023.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.se150296_pe2023.MainActivity;
import com.example.se150296_pe2023.R;
import com.example.se150296_pe2023.api.PhongBanRepository;
import com.example.se150296_pe2023.api.PhongbanService;
import com.example.se150296_pe2023.models.Phongban;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditPhongBan extends AppCompatActivity implements View.OnClickListener {
    PhongbanService phongbanService;
    EditText etName;
    Button btnSave;
    long traineeID;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_phong_ban);

        etName = (EditText) findViewById(R.id.editTextName);
        btnSave = (Button) findViewById(R.id.buttonSave);

        btnSave.setOnClickListener(this);
        phongbanService= PhongBanRepository.getPhongBanService();

        Intent intent = getIntent();
        if (intent != null) {
            btnSave.setText("Cập nhật");
            traineeID = intent.getLongExtra("phongbanID", -1);
//            Toast.makeText(this, traineeID+"", Toast.LENGTH_SHORT).show();
            Call<Phongban> call = phongbanService.getPhongBanById(traineeID);
            call.enqueue(new Callback<Phongban>() {
                @Override
                public void onResponse(Call<Phongban> call, Response<Phongban> response) {
                    Phongban traineeData = response.body();
                    if (traineeData == null) {
                        return;
                    }
                    etName.setText(traineeData.getNamePB());
                }

                @Override
                public void onFailure(Call<Phongban> call, Throwable t) {
                    Toast.makeText(EditPhongBan.this, "Co Loi", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
    private void save() {
        String name = etName.getText().toString();

        Phongban trainee = new Phongban(name);
        try {
            Call<Phongban> call = phongbanService.updatePhongBan(traineeID, trainee);
            call.enqueue(new Callback<Phongban>() {
                @Override
                public void onResponse(Call<Phongban> call, Response<Phongban> response) {
                    if (response.body() != null) {
                        Intent intent = new Intent(EditPhongBan.this, PhongBanActivity.class);
                        intent.putExtra("success_msg", true);
                        startActivity(intent);
                    } else {
                        Toast.makeText(EditPhongBan.this, "Please input all field!", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<Phongban> call, Throwable t) {
                    Toast.makeText(EditPhongBan.this, "Save fail!", Toast.LENGTH_SHORT).show();
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
