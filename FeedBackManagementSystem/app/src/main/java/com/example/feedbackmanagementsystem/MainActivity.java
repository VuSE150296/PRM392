package com.example.feedbackmanagementsystem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.feedbackmanagementsystem.activity.AddActivity;
import com.example.feedbackmanagementsystem.adpter.TraineeAdapter;
import com.example.feedbackmanagementsystem.api.APIClient;
import com.example.feedbackmanagementsystem.api.TraineeRepository;
import com.example.feedbackmanagementsystem.api.TraineeService;
import com.example.feedbackmanagementsystem.models.Trainee;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    TraineeService traineeService;

    ArrayList<Trainee> traineeArrayList;
    RecyclerView recyclerView;
    TraineeAdapter adapter;
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
        traineeService = TraineeRepository.getTraineeService();

        Intent intent = getIntent();
        Boolean statusSaving = intent.getBooleanExtra("success_msg", false);

        recyclerView = (RecyclerView) findViewById(R.id.recycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        traineeArrayList = new ArrayList<>();

        adapter = new TraineeAdapter(this, MainActivity.this);
        adapter.setTraineeArrayList(traineeArrayList);
        recyclerView.setAdapter(adapter);

        loadTrainee();
    }

    private void loadTrainee() {
//        traineeArrayList.add(new Trainee("name","email","phone","gender"));

        Call<ArrayList<Trainee>> call = traineeService.getAllTrainees();
        call.enqueue(new Callback<ArrayList<Trainee>>() {
            @Override
            public void onResponse(Call<ArrayList<Trainee>> call, Response<ArrayList<Trainee>> response) {
                if (response.isSuccessful()) {
                    traineeArrayList.addAll(response.body());
                    adapter.notifyDataSetChanged();
//                    Toast.makeText(MainActivity.this, "Call success!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Failed to load trainees", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Trainee>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Failed to load trainees", Toast.LENGTH_SHORT).show();
            }
        });
    }

    //Add
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.create_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.addIcon:
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
                Call<Trainee> call = traineeService.deleteTrainees(id);
                call.enqueue(new Callback<Trainee>() {
                    @Override
                    public void onResponse(Call<Trainee> call, Response<Trainee> response) {
                        if (response.isSuccessful()) {
                            Toast.makeText(MainActivity.this, "Delete successfully!", Toast.LENGTH_SHORT).show();
                            for (int i = 0; i < traineeArrayList.size(); i++) {
                                if (traineeArrayList.get(i).getId() == id) {
                                    traineeArrayList.remove(i);
                                    break;
                                }
                            }
                            adapter.notifyDataSetChanged();
                        }
                    }

                    @Override
                    public void onFailure(Call<Trainee> call, Throwable t) {
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