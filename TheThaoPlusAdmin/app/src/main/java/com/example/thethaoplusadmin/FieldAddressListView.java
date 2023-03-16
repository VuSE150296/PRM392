package com.example.thethaoplusadmin;

import android.os.Bundle;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class FieldAddressListView extends AppCompatActivity {
    private ListView lvFieldAddress;
    private ArrayList<FieldAddress> fieldAddressArrayList;
    private FieldAddressAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_address);

        lvFieldAddress = (ListView) findViewById(R.id.listViewAddressItem);
        fieldAddressArrayList = new ArrayList<>();
        adapter = new FieldAddressAdapter(FieldAddressListView.this, fieldAddressArrayList, R.layout.item_list);

        lvFieldAddress.setAdapter(adapter);
        getData();
    }

    public void getData() {
        fieldAddressArrayList.add(new FieldAddress("Lotee Football Stadium", "District 1, HCM", "5", "4 available"));
        fieldAddressArrayList.add(new FieldAddress("Lotee Football Stadium", "District 1, HCM", "5", "4 available"));
        fieldAddressArrayList.add(new FieldAddress("Lotee Football Stadium", "District 1, HCM", "5", "4 available"));
        fieldAddressArrayList.add(new FieldAddress("Lotee Football Stadium", "District 1, HCM", "5", "4 available"));
    }
}
