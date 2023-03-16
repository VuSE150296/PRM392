package com.example.se150296_pe2023.activity;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.se150296_pe2023.MainActivity;
import com.example.se150296_pe2023.R;
import com.example.se150296_pe2023.adpter.PhongBanAdapter;
import com.example.se150296_pe2023.api.PhongBanRepository;
import com.example.se150296_pe2023.api.PhongbanService;
import com.example.se150296_pe2023.models.Phongban;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PhongBanActivity extends AppCompatActivity {

    PhongbanService phongbanService;
    ArrayList<Phongban> phongbanArrayList;
    RecyclerView recyclerView;
    PhongBanAdapter adapter;

    private static PhongBanActivity instance;

    public static PhongBanActivity getInstance() {
        return instance;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.phong_ban_activity);
        instance = this;

        phongbanService= PhongBanRepository.getPhongBanService();
        recyclerView = (RecyclerView) findViewById(R.id.recycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        phongbanArrayList=new ArrayList<>();

        adapter = new PhongBanAdapter(PhongBanActivity.this, phongbanArrayList);
        recyclerView.setAdapter(adapter);

        loadData();
    }
    private  void loadData(){
        Call<ArrayList<Phongban>> call = phongbanService.getAllPhongBan();
        call.enqueue(new Callback<ArrayList<Phongban>>() {
            @Override
            public void onResponse(Call<ArrayList<Phongban>> call, Response<ArrayList<Phongban>> response) {
                if (response.isSuccessful()) {
                    phongbanArrayList.addAll(response.body());
                    adapter.notifyDataSetChanged();
                } else {
                    Toast.makeText(PhongBanActivity.this, "Failed to load trainees", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Phongban>> call, Throwable t) {
                Toast.makeText(PhongBanActivity.this, "Failed to load trainees", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
