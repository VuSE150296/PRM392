package com.example.sqlitedatabase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<CongViec> congViecArrayList;
    private ListView lvCongViec;
    private CongViecAdapter adapter;
    Database database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        congViecArrayList = new ArrayList<>();
        lvCongViec = (ListView) findViewById(R.id.listViewCongViec);

        adapter = new CongViecAdapter(congViecArrayList, MainActivity.this, R.layout.item_listview);
        lvCongViec.setAdapter(adapter);

        database = new Database(this, "GhiChu.sqlite", null, 1);
        database.QueryData("Create table if not exists CongViec(id Integer Primary Key Autoincrement, " + "TenCV nvarchar(200))");

        //Add data
//        database.QueryData("Insert into CongViec values(1,'Project Android')");
//        database.QueryData("Insert into CongViec values(2,'Design App')");

        getDataCongViec();
    }

    private void getDataCongViec() {
        Cursor dataCongViec = database.getData("SELECT * FROM CongViec");
        congViecArrayList.clear();
        while (dataCongViec.moveToNext()) {
            Integer id = dataCongViec.getInt(0);
            String ten = dataCongViec.getString(1);
            congViecArrayList.add(new CongViec(id, ten));
        }
        adapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.add_congviec, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.add) {
            DialogThem();
        }
        return super.onOptionsItemSelected(item);
    }

    public void DialogThem() {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_add);
        dialog.show();

        EditText editName = (EditText) dialog.findViewById(R.id.editTextAddCV);
        Button btnThem = (Button) dialog.findViewById(R.id.buttonAdd);
        Button btnCancel = (Button) dialog.findViewById(R.id.buttonCancel);

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tencv = editName.getText().toString();
                if (tencv.equals("")) {
                    Toast.makeText(MainActivity.this, "Vui lòng nhập tên công việc!", Toast.LENGTH_SHORT).show();
                } else {
                    database.QueryData("Insert into CongViec values(null, '" + tencv + "')");
                    Toast.makeText(MainActivity.this, "Đã thêm", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                    getDataCongViec();

                }
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                Toast.makeText(MainActivity.this, "Hủy", Toast.LENGTH_SHORT).show();
            }
        });

        dialog.show();
    }

    public void DialogSua(String name, int id) {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_edit);

        EditText editName = (EditText) dialog.findViewById(R.id.editTextAddCV);
        Button btnUpdate = (Button) dialog.findViewById(R.id.buttonEdit);
        Button btnCancel = (Button) dialog.findViewById(R.id.buttonCancel);

        editName.setText(name);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tenMoi = editName.getText().toString().trim();
                database.QueryData("UPDATE CongViec set TenCV='" + tenMoi + "' WHERE id='" + id + "'");
                Toast.makeText(MainActivity.this, "Đã cập nhật!", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
                getDataCongViec();
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                Toast.makeText(MainActivity.this, "Hủy", Toast.LENGTH_SHORT).show();
            }
        });

        dialog.show();
    }

    public void DialogXoa(String name, int id) {
        AlertDialog.Builder dialogXoa = new AlertDialog.Builder(this);
        dialogXoa.setMessage("Bạn có muốn xóa công việc " + name + " không?");
        dialogXoa.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                database.QueryData("DELETE FROM CongViec WHERE Id = '" + id + "' ");
                Toast.makeText(MainActivity.this, "Đã xóa " + name, Toast.LENGTH_SHORT).show();
                getDataCongViec();
            }
        });
        dialogXoa.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        dialogXoa.show();
    }

}