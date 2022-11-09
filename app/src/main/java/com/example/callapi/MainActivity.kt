package com.example.callapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import com.example.callapi.databinding.ActivityMainBinding
import com.example.callapi.viewmodel.ApiViewModel

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!
    private val apiViewModel: ApiViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initObserve()
        apiViewModel.callApi()
    }

    private fun initObserve() {
        apiViewModel.callApiResult.observe(this) { result ->
            when (result) {
                is ApiViewModel.CallApiResult.ResultOk -> {
                    binding.text.text = result.result.toString()
                }
                is  ApiViewModel.CallApiResult.ResultError -> {
                    Toast.makeText(this, "Error", Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}