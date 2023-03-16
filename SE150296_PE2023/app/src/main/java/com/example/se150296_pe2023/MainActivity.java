package com.example.se150296_pe2023;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.se150296_pe2023.activity.AddActivity;
import com.example.se150296_pe2023.activity.PhongBanActivity;
import com.example.se150296_pe2023.adpter.NhanVienAdapter;
import com.example.se150296_pe2023.api.NhanVienRepository;
import com.example.se150296_pe2023.api.NhanVienService;
import com.example.se150296_pe2023.models.Nhanvien;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    NhanVienService nhanVienService;

    ArrayList<Nhanvien> nhanvienArrayList;
    RecyclerView recyclerView;
    Button buttonPhongBan;
    NhanVienAdapter adapter;
    private static MainActivity instance;

    public static MainActivity getInstance() {
        return instance;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        instance = this;

        // Khởi tạo Service
        nhanVienService = NhanVienRepository.getTraineeService();

        Intent intent = getIntent();
        Boolean statusSaving = intent.getBooleanExtra("success_msg", false);

        recyclerView = (RecyclerView) findViewById(R.id.recycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        nhanvienArrayList = new ArrayList<>();

        adapter = new NhanVienAdapter(this, MainActivity.this);
        adapter.setNhanvienArrayList(nhanvienArrayList);
        recyclerView.setAdapter(adapter);

        loadTrainee();

        buttonPhongBan=(Button) findViewById(R.id.buttonChangeActivity);
        buttonPhongBan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentPhongBan=new Intent(MainActivity.this, PhongBanActivity.class);
                startActivity(intentPhongBan);
            }
        });
    }

    private void loadTrainee() {

        Call<ArrayList<Nhanvien>> call = nhanVienService.getAllNhanVien();
        call.enqueue(new Callback<ArrayList<Nhanvien>>() {
            @Override
            public void onResponse(Call<ArrayList<Nhanvien>> call, Response<ArrayList<Nhanvien>> response) {
                if (response.isSuccessful()) {
                    nhanvienArrayList.addAll(response.body());
                    adapter.notifyDataSetChanged();
                } else {
                    Toast.makeText(MainActivity.this, "Failed to load trainees", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Nhanvien>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Failed to load trainees", Toast.LENGTH_SHORT).show();
            }
        });
    }

    //Add
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_create, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menuAdd:
                Intent intent = new Intent(this, AddActivity.class);
                startActivity(intent);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    public void delete(long id, String name) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Bạn có muốn xóa " + name + " không?");
        builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Call<Nhanvien> call = nhanVienService.deleteNhanVien(id);
                call.enqueue(new Callback<Nhanvien>() {
                    @Override
                    public void onResponse(Call<Nhanvien> call, Response<Nhanvien> response) {
                        if (response.isSuccessful()) {
                            Toast.makeText(MainActivity.this, "Delete successfully!", Toast.LENGTH_SHORT).show();
                            for (int i = 0; i < nhanvienArrayList.size(); i++) {
                                if (nhanvienArrayList.get(i).getId() == id) {
                                    nhanvienArrayList.remove(i);
                                    break;
                                }
                            }
                            adapter.notifyDataSetChanged();
                        }
                    }

                    @Override
                    public void onFailure(Call<Nhanvien> call, Throwable t) {
                        Toast.makeText(MainActivity.this, "Có lỗi", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
        builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.show();
    }
}