package com.college.quiz1_question;

import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //This gets the toolbar from the layout:
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar2);
        toolbar.setTitle(R.string.second_activity);
        setSupportActionBar(toolbar);



        // Here we need the Action Bar
        ActionBar myBar = getSupportActionBar();
        myBar.setDisplayHomeAsUpEnabled(true);


    }
}