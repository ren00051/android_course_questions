package com.college.questions;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set the layout for this activity
        setContentView(R.layout.activity_second);

        // Find the BottomNavigationView in the layout
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        // Set the selected item in the BottomNavigationView
        bottomNavigationView.setSelectedItemId(R.id.second_id);

        // Set an item selected listener for the BottomNavigationView
        bottomNavigationView.setOnItemSelectedListener(item ->
                {
                    // Switch statement to handle different menu item selections
                    switch (item.getItemId()) {

                        // If "Home" item is selected
                        case R.id.home_id:
                            // Start FirstActivity
                            startActivity(new Intent(getApplicationContext(), FirstActivity.class));
                            return true;

                        // If "Second" item is selected
                        case R.id.second_id:
                            // Do nothing, already in SecondActivity
                            return true;

                        // If "Third" item is selected
                        case R.id.third_id:
                            // Start ThirdActivity
                            startActivity(new Intent(getApplicationContext(), ThirdActivity.class));
                            return true;

                        case R.id.fourth_id:
                            startActivity(new Intent(getApplicationContext(), FourthActivity.class));
                            return true;

                    }

                // Return false if no item is selected
                return false;
                }
        );

    }
}