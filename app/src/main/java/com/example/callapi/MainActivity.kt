package com.example.callapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import com.example.callapi.databinding.ActivityMainBinding
import com.example.callapi.viewmodel.ApiViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val apiViewModel: ApiViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initObserve()
        apiViewModel.callApi()
    }

    fun initObserve() {
        apiViewModel.callApiResult.observe(this) { result ->
            when (result) {
                is ApiViewModel.CallApiResult.ResultOk -> {
                    Log.e("Data", result.result.body().toString())
                }
                is  ApiViewModel.CallApiResult.ResultError -> {
                    Toast.makeText(this, "Error", Toast.LENGTH_LONG).show()
                }
            }
        }
    }

}