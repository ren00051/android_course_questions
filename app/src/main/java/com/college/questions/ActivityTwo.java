package com.college.questions;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;



public class ActivityTwo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        //TODO 4 - Get the textview to display
        TextView textView = findViewById(R.id.textView);
        //TODO 5 - Retrieve the data passed : Rank and Name
        Intent intent2 = getIntent();
        String nameRetrived = intent2.getStringExtra("name");
        int rankRetrived = intent2.getIntExtra("rank",0);

        //TODO 6 - Display the retrieved information on the screen
        //on the textview, one per line

        textView.setText("Name: " + nameRetrived + "\nRank: " + rankRetrived);
        //TODO 7 - Return to previous activity when BACK button is clicked
        Button btnBack = findViewById(R.id.backButtonId);
        btnBack.setOnClickListener(c->{
            Intent intent3 = new Intent(ActivityTwo.this, ActivityOne.class);
            startActivity(intent3);
        });
    }
}