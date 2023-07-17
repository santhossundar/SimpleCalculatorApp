package com.calculator.app.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.calculator.app.R

class MainFragment : Fragment() {
    private lateinit var viewModel: MainViewModel

    companion object {
        fun newInstance() = MainFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        var view = inflater.inflate(R.layout.fragment_main, container, false)

        var edtFirstValue = view.findViewById<EditText>(R.id.fragment_main_edt_value_one)
        var edtSecondValue = view.findViewById<EditText>(R.id.fragment_main_edt_value_two)
        var resultTxtView = view.findViewById<TextView>(R.id.fragment_main_result)
        var errorTxtView = view.findViewById<TextView>(R.id.fragment_main_error)

        var btnAdd = view.findViewById<Button>(R.id.fragment_main_btn_add)
        btnAdd.setOnClickListener {
            errorTxtView.visibility = View.GONE
            val firstValue = edtFirstValue.text.toString()
            val secondValue = edtSecondValue.text.toString()

            if(viewModel.validateUserInputFields(firstValue, secondValue)){
                viewModel.add(firstValue, secondValue)
                resultTxtView.text = viewModel.result.value.toString()
            }

            viewModel.userInputFieldError.observe(viewLifecycleOwner) {error ->
                errorTxtView.visibility = View.VISIBLE
                errorTxtView.text = error
            }
        }

        var btnSubtract = view.findViewById<Button>(R.id.fragment_main_btn_subtract)
        btnSubtract.setOnClickListener {
            errorTxtView.visibility = View.GONE
            val firstValue = edtFirstValue.text.toString()
            val secondValue = edtSecondValue.text.toString()

            if(viewModel.validateUserInputFields(firstValue, secondValue)){
                viewModel.subtract(firstValue, secondValue)
                resultTxtView.text = viewModel.result.value.toString()
            }

            viewModel.userInputFieldError.observe(viewLifecycleOwner) {error ->
                errorTxtView.visibility = View.VISIBLE
                errorTxtView.text = error
            }
        }

        var btnMultiply = view.findViewById<Button>(R.id.fragment_main_btn_multiply)
        btnMultiply.setOnClickListener {
            errorTxtView.visibility = View.GONE
            val firstValue = edtFirstValue.text.toString()
            val secondValue = edtSecondValue.text.toString()

            if(viewModel.validateUserInputFields(firstValue, secondValue)){
                viewModel.multiply(firstValue, secondValue)
                resultTxtView.text = viewModel.result.value.toString()
            }

            viewModel.userInputFieldError.observe(viewLifecycleOwner) {error ->
                errorTxtView.visibility = View.VISIBLE
                errorTxtView.text = error
            }
        }

        return view
    }

}