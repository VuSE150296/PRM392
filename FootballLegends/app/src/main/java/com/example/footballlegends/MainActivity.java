package com.example.footballlegends;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvLegends;
    ArrayList<FootballLegends> legendsList;
    FootballAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnhXa();
        adapter = new FootballAdapter(this, R.layout.legends_item, legendsList);
        lvLegends.setAdapter(adapter);
    }

    private void AnhXa() {
        lvLegends = (ListView) findViewById(R.id.listViewLegends);
        legendsList = new ArrayList<>();

        legendsList.add(new FootballLegends(R.drawable.pele_image, "Pele", "23 tháng 10, 1940 (72 tuổi)", R.drawable.co_brazil));
        legendsList.add(new FootballLegends(R.drawable.neyma, "Neyma", "5 tháng 2, 1992 (30 tuổi)", R.drawable.co_brazil));
        legendsList.add(new FootballLegends(R.drawable.ronaldo_de_lima, "Ronaldo De Lima", "18 tháng 9, 1976 (46 tuổi)", R.drawable.co_brazil));
        legendsList.add(new FootballLegends(R.drawable.messi, "Messi", "24 tháng 6, 1987 (35 tuổi)", R.drawable.argentina));
        legendsList.add(new FootballLegends(R.drawable.ronaldinho, "Ronaldinho", "21 tháng 3, 1980 (42 tuổi)", R.drawable.co_brazil));
    }
}