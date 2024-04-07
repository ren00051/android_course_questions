package com.college.questions;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/*
 TODO:
 Implement the DIV, SUB, MUL, and DIV operations

 */
public class MainActivity extends AppCompatActivity {

    static private final String TAG = "MainActivity";

    double result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText param1Text = findViewById(R.id.operand_one_edit_1);

        EditText param2Text = findViewById(R.id.operand_two_edit_2);

        TextView resultTv = findViewById(R.id.operation_result);


        Button btnAdd = findViewById(R.id.add_button);

        btnAdd.setOnClickListener(c->{
            int param1 = Integer.parseInt(param1Text.getText().toString());
            int param2 = Integer.parseInt(param2Text.getText().toString());
            result = param1 + param2;
            resultTv.setText(Double.toString(result));
        });
        
        Button btnSub = findViewById(R.id.sub_button);
        btnSub.setOnClickListener(c->{
            int param1 = Integer.parseInt(param1Text.getText().toString());
            int param2 = Integer.parseInt(param2Text.getText().toString());
            result = param1 - param2;
            resultTv.setText(Double.toString(result));
        });

        Button btnMul = findViewById(R.id.mul_button);
        btnMul.setOnClickListener(c->{
            int param1 = Integer.parseInt(param1Text.getText().toString());
            int param2 = Integer.parseInt(param2Text.getText().toString());
            result = param1 * param2;
            resultTv.setText(Double.toString(result));
        });

        Button btnDiv = findViewById(R.id.div_button);
        btnDiv.setOnClickListener(c->{
            int param1 = Integer.parseInt(param1Text.getText().toString());
            int param2 = Integer.parseInt(param2Text.getText().toString());
            if (param2 != 0){
                result = (double) param1 / param2;
            }
            resultTv.setText(Double.toString(result));
        });


    }



}
