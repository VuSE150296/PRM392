package com.example.recyclerviewex1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<User> userList;
    private RecyclerView recyclerView;
    private UserAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userList=new ArrayList<>();

        recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this,1));

        adapter=new UserAdapter(userList);
        recyclerView.setAdapter(adapter);

        addData();
    }

    private void addData(){
        userList.add(new User("NguyenTT","Tran Thanh Nguyen","nguyentt@fpt.edu.vn"));
        userList.add(new User("AnTV","Tran Van An","antv@gmail.com"));
        userList.add(new User("BangTT","Tran Thanh Bang","bangtt@gmail.com"));
        userList.add(new User("NguyenTT","Tran Thanh Nguyen","nguyentt@fpt.edu.vn"));
        userList.add(new User("AnTV","Tran Van An","antv@gmail.com"));
        userList.add(new User("BangTT","Tran Thanh Bang","bangtt@gmail.com"));
        userList.add(new User("NguyenTT","Tran Thanh Nguyen","nguyentt@fpt.edu.vn"));
        userList.add(new User("AnTV","Tran Van An","antv@gmail.com"));
        userList.add(new User("BangTT","Tran Thanh Bang","bangtt@gmail.com"));

    }
}