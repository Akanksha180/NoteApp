package com.akanksha.noteapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.Calendar;

public class DetailsScreen extends AppCompatActivity {

    TextView title,description;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_screen);

        title = findViewById(R.id.tv_noteTitle);
        description = findViewById(R.id.tv_noteDes);

    }
}