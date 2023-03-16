package com.example.pe.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.pe.MainActivity;
import com.example.pe.R;
import com.example.pe.api.PersonRepository;
import com.example.pe.api.PersonService;
import com.example.pe.models.Person;
import com.google.android.material.textfield.TextInputLayout;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditActivity extends AppCompatActivity implements View.OnClickListener {
    PersonService personService;
    TextView tvHeader;
    TextInputLayout etName, etPhone;
    Button btnSave;
    long personID;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_activity);

        tvHeader=(TextView) findViewById(R.id.textView);
        etName = (TextInputLayout) findViewById(R.id.textInputLayoutName);
        etPhone = (TextInputLayout) findViewById(R.id.textInputLayoutPhone);
        btnSave = (Button) findViewById(R.id.buttonSubmit);

        btnSave.setOnClickListener(this);
        personService = PersonRepository.getPersonService();

        Intent intent = getIntent();
        if (intent != null) {
            tvHeader.setText("Update Person");
            btnSave.setText("Update");
            personID = intent.getLongExtra("personID", -1);
            Call<Person> call = personService.getPersonByID(personID);
            call.enqueue(new Callback<Person>() {
                @Override
                public void onResponse(Call<Person> call, Response<Person> response) {
                    Person personData = response.body();
                    if (personData == null) {
                        return;
                    }

                    etName.getEditText().setText(personData.getName());
                    etPhone.getEditText().setText(personData.getPhone());
                }

                @Override
                public void onFailure(Call<Person> call, Throwable t) {
                    Toast.makeText(EditActivity.this, "Co Loi", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    private void save() {
        String name = etName.getEditText().getText().toString();
        String phone = etPhone.getEditText().getText().toString();

        if (name.isEmpty() || phone.isEmpty()) {
            Toast.makeText(EditActivity.this, "Please input all field!", Toast.LENGTH_SHORT).show();
        } else {
            Person person = new Person(name, phone);
            try {
                Call<Person> call = personService.updatePerson(personID, person);
                call.enqueue(new Callback<Person>() {
                    @Override
                    public void onResponse(Call<Person> call, Response<Person> response) {

                        if (response.body() != null) {
                            Intent intent = new Intent(EditActivity.this, MainActivity.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(EditActivity.this, "Please input all field!", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Person> call, Throwable t) {
                        Toast.makeText(EditActivity.this, "Save fail!", Toast.LENGTH_SHORT).show();
                    }
                });
            } catch (Exception e) {
                Toast.makeText(EditActivity.this, "Loi!", Toast.LENGTH_SHORT).show();
                Log.d("Loi", e.getMessage());
            }
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonSubmit:
                save();
                break;
        }
    }
}
