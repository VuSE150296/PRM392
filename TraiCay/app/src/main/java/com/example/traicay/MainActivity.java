package com.example.traicay;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvTraiCay;
    ArrayList<TraiCayItem> traiCayList;
    TraiCayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnhXa();

        adapter = new TraiCayAdapter(this, R.layout.traicay_item, traiCayList);
        lvTraiCay.setAdapter(adapter);
    }

    private void AnhXa() {
        lvTraiCay = (ListView) findViewById(R.id.listViewTraiCay);
        traiCayList = new ArrayList<>();

        traiCayList.add(new TraiCayItem(R.drawable.buoi, "Bưởi", "Mô tả bưởi"));
        traiCayList.add(new TraiCayItem(R.drawable.dua, "Dừa", "Mô tả dừa"));
        traiCayList.add(new TraiCayItem(R.drawable.cam, "Cam", "Mô tả cam"));
        traiCayList.add(new TraiCayItem(R.drawable.tao, "Táo", "Mô tả táo"));
        traiCayList.add(new TraiCayItem(R.drawable.xoai, "Xoài", "Mô tả xoài"));
        traiCayList.add(new TraiCayItem(R.drawable.saurieng, "Sầu riêng", "Mô tả sầu riêng"));
    }
}