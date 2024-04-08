package com.college.quiz1_question;

import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        //This gets the toolbar from the layout:
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar3);
        toolbar.setTitle(R.string.third_activity);
        toolbar.setLogo(R.drawable.ic_launcher_foreground);
        toolbar.setSubtitle("wulala");
        setSupportActionBar(toolbar);

        ActionBar myBar = getSupportActionBar();
        myBar.setDisplayHomeAsUpEnabled(true);




    }
}