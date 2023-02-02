package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ListView lvLanguage;
    ArrayList<String> arrayLanguage;
    Button btnAdd, btnUpdate;
    EditText etLanguage;
    String REQUIRE = "require";
    ArrayAdapter adapter;
    int arrayPosition = -1;
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvLanguage = (ListView) findViewById(R.id.ListViewLanguage);
        btnAdd = (Button) findViewById(R.id.buttonAdd);
        btnUpdate = (Button) findViewById(R.id.buttonUpdate);
        etLanguage = (EditText) findViewById(R.id.editTextLanguage);

        builder = new AlertDialog.Builder(this);

        btnAdd.setOnClickListener(this);
        btnUpdate.setOnClickListener(this);

        arrayLanguage = new ArrayList<>();
        arrayLanguage.add("Android");
        arrayLanguage.add("PHP");
        arrayLanguage.add("IOS");
        arrayLanguage.add("Unity");
        arrayLanguage.add("ASP.Net");

        adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, arrayLanguage);
        lvLanguage.setAdapter(adapter);

        lvLanguage.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, arrayLanguage.get(position), Toast.LENGTH_SHORT).show();
                String oldValue = arrayLanguage.get(position);
                etLanguage.setText(oldValue);
                arrayPosition = position;
            }
        });

        lvLanguage.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                builder.setMessage("Do you want DELETE this item?").setCancelable(false).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String oldLanguage = arrayLanguage.get(position);
                        arrayLanguage.remove(position);
                        adapter.notifyDataSetChanged();
                        Toast.makeText(MainActivity.this, oldLanguage + " was deleted!", Toast.LENGTH_SHORT).show();

                    }
                }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                        Toast.makeText(MainActivity.this, "Canceled!", Toast.LENGTH_SHORT).show();
                    }
                });
                AlertDialog alert = builder.create();
                alert.setTitle("DELETE !!!");
                alert.show();
                return false;
            }
        });
    }

    private boolean checkInput() {
        if (TextUtils.isEmpty(etLanguage.getText().toString())) {
            etLanguage.setError(REQUIRE);
            return false;
        }
        return true;
    }

    private void add() {
        if (!checkInput()) {
            return;
        }
        String newLanguage = etLanguage.getText().toString();
        arrayLanguage.add(newLanguage);
        adapter.notifyDataSetChanged();
        etLanguage.setText("");
    }

    private void update() {
        if (!checkInput() || arrayPosition == -1) {
            return;
        }
        String newLanguage = etLanguage.getText().toString();
        arrayLanguage.set(arrayPosition, newLanguage);
        adapter.notifyDataSetChanged();
        etLanguage.setText("");
        arrayPosition = -1;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonAdd:
                add();
                break;
            case R.id.buttonUpdate:
                update();
                break;
        }
    }
}