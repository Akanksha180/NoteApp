package com.akanksha.noteapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    EditText email,password;
    TextView signup;
    Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login_btn);
        signup = findViewById(R.id.tv_signup);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            login.setBackgroundTintList(ContextCompat.getColorStateList(MainActivity.this, R.color.white));
        }

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = email.getText().toString();
                String pass = password.getText().toString();

                SharedPreferences sharedPreferences = getSharedPreferences("MYPREFS",MODE_PRIVATE);
                String userDetails = sharedPreferences.getString(user + pass+"data","Email or Password is Incorrect");
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("display",userDetails);
                editor.commit();

                Intent home = new Intent(MainActivity.this,HomeActivity.class);
                startActivity(home);
                finish();
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Signup = new Intent(MainActivity.this,SignupActivity.class);
                startActivity(Signup);
            }
        });
    }
}