package com.calculator.app.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel() : ViewModel() {
    var result = MutableLiveData<Double>(0.0)

    fun add(valueOne: String, valueTwo: String) {
        val firstValue = valueOne.toDouble()
        val secondValue = valueTwo.toDouble()
        result.value = firstValue + secondValue
    }
}