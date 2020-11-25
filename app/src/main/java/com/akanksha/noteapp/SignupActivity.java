package com.akanksha.noteapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity {


    Button signup;
    TextView login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        final EditText name,mobile,email,password;
        name = findViewById(R.id.et_name);
        mobile = findViewById(R.id.et_mobile);
        email = findViewById(R.id.et_email);
        password = findViewById(R.id.et_password);
        signup = findViewById(R.id.signup_btn);
        login = findViewById(R.id.tv_login);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            signup.setBackgroundTintList(ContextCompat.getColorStateList(SignupActivity.this,R.color.white));
        }

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("MYPREFS", MODE_PRIVATE);
                String newUser = name.getText().toString();
                String newMobile = mobile.getText().toString();
                String newEmail = email.getText().toString();
                String newPassword = password.getText().toString();

                if (TextUtils.isEmpty(newUser) || TextUtils.isEmpty(newMobile) || TextUtils.isEmpty(newEmail) || TextUtils.isEmpty(newPassword)) {
                    Toast.makeText(SignupActivity.this, "Fields are Empty", Toast.LENGTH_SHORT).show();
                } else if (newMobile.length() < 10) {
                    Toast.makeText(SignupActivity.this, "Enter Correct Mobile Number", Toast.LENGTH_SHORT).show();
                } else if (newEmail.length() < 4 || newEmail.length() > 25) {
                    Toast.makeText(SignupActivity.this, "Email is not valid", Toast.LENGTH_SHORT).show();
                } else if (newPassword.length() < 8 || newPassword.length() > 15 || newPassword == newUser) {
                    Toast.makeText(SignupActivity.this, "Invalid password", Toast.LENGTH_SHORT).show();
                } else {

                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(newEmail + newPassword + "data", newUser + "/n" + newMobile);
                    Intent login = new Intent(SignupActivity.this, MainActivity.class);
                    startActivity(login);
                    finish();
                }
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent login = new Intent(SignupActivity.this,MainActivity.class);
                startActivity(login);
            }
        });


    }

}