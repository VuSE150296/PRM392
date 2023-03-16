package com.example.datastorage;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Database database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        database = new Database(this, "GhiChu.sqlite", null, 1);
        database.QueryData("Create table if not exists CongViec(id Integer Primary Key Autoincrement, " + "TenCV nvarchar(200))");

        //insert Data
//        database.QueryData("Insert into CongViec values(null,'Project Android')");
//        database.QueryData("Insert into CongViec values(null,'Design App')");

        Cursor dataCongViec = database.getData("SELECT * from CongViec");
        while (dataCongViec.moveToNext()) {
            String ten = dataCongViec.getString(1);
            Toast.makeText(this, ten, Toast.LENGTH_SHORT).show();
        }
    }
}