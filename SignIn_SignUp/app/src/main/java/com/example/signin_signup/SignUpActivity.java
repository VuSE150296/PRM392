package com.example.signin_signup;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etUsername, etPassword, etConfirmPassword;
    TextView tvSignIn;
    Button btnSignUp;

    final String REQUIRE = "Require";

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_sign_up);

        etUsername = (EditText) findViewById(R.id.editTextUsername);
        etPassword = (EditText) findViewById(R.id.editTextPassword);
        etConfirmPassword = (EditText) findViewById(R.id.editTextConfirmPassword);
        tvSignIn = (TextView) findViewById(R.id.textViewSignIn);
        btnSignUp = (Button) findViewById(R.id.buttonSignUp);

        tvSignIn.setOnClickListener(this);
        btnSignUp.setOnClickListener(this);
    }

    private boolean checkInput() {
        if (TextUtils.isEmpty(etUsername.getText().toString())) {
            etUsername.setError(REQUIRE);
            return false;
        }
        if (TextUtils.isEmpty(etPassword.getText().toString())) {
            etPassword.setError(REQUIRE);
            return false;
        }
        if (TextUtils.isEmpty(etConfirmPassword.getText().toString())) {
            etConfirmPassword.setError(REQUIRE);
            return false;
        }
        if (!TextUtils.equals(etPassword.getText().toString(), etConfirmPassword.getText().toString())) {
            Toast.makeText(this, "Password are not match!", Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }

    private void signUp() {
        if (!checkInput()) {
            return;
        }
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
    }

    private void signInForm() {
        Intent intent = new Intent(this, SignInActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonSignUp:
                signUp();
                break;
            case R.id.textViewSignIn:
                signInForm();
                break;
        }
    }
}
