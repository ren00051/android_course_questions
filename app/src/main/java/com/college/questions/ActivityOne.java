package com.college.questions;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;


/*

 Complete the TODOs below

*/

public class ActivityOne extends AppCompatActivity {

    static final String KEY_NAME="Name";
    static final String KEY_RANK="Rank";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);

        //TODO 1 - Create the intent

        //TODO 2 - Save information to pass : Name and Rank

        //TODO 3 - start the activity when the button is clicked
        Button btn = findViewById(R.id.gotoSecondId);
        btn.setOnClickListener(c->{
            EditText name = findViewById(R.id.nameId);
            EditText rank = findViewById(R.id.rankId);

            Intent intent = new Intent(ActivityOne.this, ActivityTwo.class);
            intent.putExtra("name", name.getText().toString());
            intent.putExtra("rank", Integer.parseInt(rank.getText().toString()));
            startActivity(intent);
        });
    }
}