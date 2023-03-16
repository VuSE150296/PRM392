package com.example.roomdatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditPersonActivity extends AppCompatActivity {

    private EditText etFirstName;
    private EditText etLastName;
    private Button btnSave;
    private int mPersonId;
    private Intent intent;
    private AppDatabase mDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_edit);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initViews();
        mDb = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "app-database").build();
        intent = getIntent();
        if(intent != null && intent.hasExtra(Constants.UPDATE_Person_Id)){
            btnSave.setText("Update");
            mPersonId = intent.getIntExtra(Constants.UPDATE_Person_Id, -1);

            AppExecutors.getInstance().diskIO().execute(new Runnable() {
                @Override
                public void run() {
                    Person person = mDb.personDao().loadPersonById(mPersonId);
                    populateUI(person);
                }
            });
        }
    }

    private void populateUI(Person person){
        if(person == null){
            return;
        }

        etFirstName.setText(person.getFirstName());
        etLastName.setText(person.getLastName());
    }
    private void initViews(){
        etFirstName =findViewById(R.id.etFirstName);
        etLastName =findViewById(R.id.etLastName);

        btnSave = findViewById(R.id.btnSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSaveButtonClicked();
            }
        });
    }

    public void onSaveButtonClicked(){
        final Person person =new Person(
                etFirstName.getText().toString(),
                etLastName.getText().toString());
        AppExecutors.getInstance().diskIO().execute(new Runnable() {
            @Override
            public void run() {
                if(!intent.hasExtra(Constants.UPDATE_Person_Id)){
                    mDb.personDao().insert(person);
                }else{
                    person.setUid(mPersonId);
                    mDb.personDao().update(person);
                }
                finish();
            }
        });
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}