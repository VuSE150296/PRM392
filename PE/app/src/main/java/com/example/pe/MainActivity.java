package com.example.pe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.pe.activity.AddActivity;
import com.example.pe.activity.EditActivity;
import com.example.pe.adapter.PersonAdapter;
import com.example.pe.api.PersonRepository;
import com.example.pe.api.PersonService;
import com.example.pe.models.Person;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    PersonService personService;
    ArrayList<Person> personArrayList;
    RecyclerView recyclerView;
    PersonAdapter personAdapter;
    private static MainActivity instance;

    public static MainActivity getInstance() {
        return instance;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        instance = this;

        personService = PersonRepository.getPersonService();

        recyclerView = (RecyclerView) findViewById(R.id.recycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        personArrayList = new ArrayList<>();

        personAdapter = new PersonAdapter(this, MainActivity.this);
        personAdapter.setPersonArrayList(personArrayList);
        recyclerView.setAdapter(personAdapter);

        loadPerson();
    }

    private void loadPerson() {
        Call<ArrayList<Person>> call = personService.getAllPerson();
        call.enqueue(new Callback<ArrayList<Person>>() {
            @Override
            public void onResponse(Call<ArrayList<Person>> call, Response<ArrayList<Person>> response) {
                if (response.isSuccessful()) {
                    personArrayList.addAll(response.body());
                    personAdapter.notifyDataSetChanged();
                } else {
                    Toast.makeText(MainActivity.this, "Failed to load trainees", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Person>> call, Throwable t) {

            }
        });
    }

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

    public void editPerson(long id) {
        Intent intent = new Intent(MainActivity.this, EditActivity.class);
        intent.putExtra("personID", id);
        startActivity(intent);
    }

    public void deletePerson(long id, String name) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Do you want to delete " + name + "?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Call<Person> call = personService.deletePerson(id);
                call.enqueue(new Callback<Person>() {
                    @Override
                    public void onResponse(Call<Person> call, Response<Person> response) {
                        if (response.isSuccessful()) {
                            Toast.makeText(MainActivity.this, "Delete successfully!", Toast.LENGTH_SHORT).show();
                            for (int i = 0; i < personArrayList.size(); i++) {
                                if (personArrayList.get(i).getId() == id) {
                                    personArrayList.remove(i);
                                    break;
                                }
                            }
                            personAdapter.notifyDataSetChanged();
                        }
                    }

                    @Override
                    public void onFailure(Call<Person> call, Throwable t) {
                        Toast.makeText(MainActivity.this, "Có lỗi", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.show();
    }
}