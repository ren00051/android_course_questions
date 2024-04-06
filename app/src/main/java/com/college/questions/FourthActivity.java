package com.college.questions;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class FourthActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.fourth_id);

        bottomNavigationView.setOnItemSelectedListener( item -> {
            switch(item.getItemId()){
                case R.id.home_id:
                    startActivity(new Intent(getApplicationContext(), FirstActivity.class));
                    return true;
                case R.id.second_id:
                    startActivity(new Intent(getApplicationContext(), SecondActivity.class));
                    return true;
                case R.id.third_id:
                    startActivity(new Intent(getApplicationContext(),ThirdActivity.class));
                    return true;
                case R.id.fourth_id:
                    return true;
            }
            return false;

        });

    }
}
