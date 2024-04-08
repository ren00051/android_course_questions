package com.college.quiz1_question.data;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CurrencyConverterViewModel extends ViewModel {

    public MutableLiveData<Float>  inputAmount = new MutableLiveData<>();
    public MutableLiveData<Float>  resultAmount = new MutableLiveData<>();


}
