package com.college.quiz1_question.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.college.quiz1_question.R;
import com.college.quiz1_question.data.CurrencyConverterViewModel;

import java.util.Locale;

/*
   TODO: Use ViewModel to store the data and keep the data when the device is rotated.
    
 */
public class MainActivity extends AppCompatActivity {

    static private final Float CONVERSION_RATE = 0.80F;
    private CurrencyConverterViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewModel = new ViewModelProvider(this).get(CurrencyConverterViewModel.class);


        EditText inputView = findViewById(R.id.entryId);
        Float inputAmount = viewModel.inputAmount.getValue();
        if (inputAmount != null) {
            inputView.setText(String.valueOf(inputAmount));
        }

        TextView resultView = findViewById(R.id.resultId);
        Float resultAmount = viewModel.resultAmount.getValue();
        if (resultAmount != null) {
            resultView.setText(String.valueOf(resultAmount));
        }

        Button buttonConvert = findViewById(R.id.convertButton);

        buttonConvert.setOnClickListener( view ->  {

            convert_currency(view);

        } );

    }

    public void convert_currency(View view) {

        EditText inputView = findViewById(R.id.entryId);

        //"11.0"
        String inputAmount = inputView.getText().toString();

        if (!inputAmount.isEmpty()) {
            Float inputAmountDecimal = Float.valueOf(inputAmount);
            //postValue() is to set a new value
            viewModel.inputAmount.postValue(inputAmountDecimal);

            Float resultFloat = inputAmountDecimal * CONVERSION_RATE;
            viewModel.resultAmount.postValue(resultFloat);

            TextView resultView = findViewById(R.id.resultId);

            resultView.setText(String.format (Locale.CANADA, "%.2f  Euros", resultFloat));
        }
    }
}