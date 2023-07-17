package com.calculator.app.ui.main

import androidx.core.text.isDigitsOnly
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel() : ViewModel() {
    var result = MutableLiveData<Double>(0.0)

    private val _userInputFieldError = MutableLiveData<String?>()
    val userInputFieldError: LiveData<String?> = _userInputFieldError

    private val _operationError = MutableLiveData<String?>()
    val operationError: LiveData<String?> = _operationError

    fun validateUserInputFields(firstValue: String, secondValue: String): Boolean {
        if (firstValue.isBlank() || secondValue.isBlank()) {
            _userInputFieldError.value = "Input fields cannot be blank!"
            return false
        } else if (!firstValue.isDigitsOnly() || !secondValue.isDigitsOnly()) {
            _userInputFieldError.value = "Only numeric characters can be allowed!"
            return false
        } else {
            _userInputFieldError.value = null
            return true
        }
    }

    fun add(valueOne: String, valueTwo: String) {
        val firstValue = valueOne.toDouble()
        val secondValue = valueTwo.toDouble()
        result.value = firstValue + secondValue
    }

    fun subtract(valueOne: String, valueTwo: String) {
        val firstValue = valueOne.toDouble()
        val secondValue = valueTwo.toDouble()
        result.value = firstValue - secondValue
    }

    fun multiply(valueOne: String, valueTwo: String) {
        val firstValue = valueOne.toDouble()
        val secondValue = valueTwo.toDouble()
        result.value = firstValue * secondValue
    }

    fun divide(valueOne: String, valueTwo: String) {
        val firstValue = valueOne.toDouble()
        val secondValue = valueTwo.toDouble()

        val dividedValue = firstValue / secondValue

        if(dividedValue.isFinite()){
            result.value = dividedValue
        } else {
            _operationError.value = "Cannot divide by zero!"
        }
    }
}