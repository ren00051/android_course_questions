package com.college.questions;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.college.questions.databinding.ActivityMainBinding;

import org.w3c.dom.Text;

import java.util.Locale;

/*
 TODO: Convert the below code to use View Binding
*/

public class MainActivity extends AppCompatActivity {

    static private final String TAG = "MainActivity";

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        //setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //Button  addButton  = findViewById(R.id.add_button);
        Button addButton = binding.addButton;

        //TextView tvResult = findViewById(R.id.operation_result);
        TextView tvResult = binding.operationResult;

        addButton.setOnClickListener( (v) -> {
            //EditText operandOne = findViewById(R.id.operand_one_edit);
            EditText operandOne = binding.operandOneEdit;
            //EditText operandTwo  = findViewById(R.id.operand_two_edit);
            EditText operandTwo = binding.operandTwoEdit;

            String firstNumber = operandOne.getText().toString();
            String secondNumber = operandTwo.getText().toString();
            try {
                Integer numberOne = Integer.valueOf( firstNumber);
                Integer numberTwo = Integer.valueOf(secondNumber);
                int total = numberOne + numberTwo;

                tvResult.setText(String.format(Locale.CANADA, "%d", total));
            } catch (NumberFormatException e) {
                tvResult.setText(R.string.computationError);
            }

        });
    }


}
