package com.example.callapi.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.callapi.model.QuoteList
import com.example.callapi.repository.ApiRepository
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import retrofit2.Response

class ApiViewModel : ViewModel() {
    val callApiResult = MutableLiveData<CallApiResult>()
    private val apiRepository = ApiRepository()

    sealed class CallApiResult {
        class ResultOk(val result: Response<QuoteList>) : CallApiResult()
        object ResultError: CallApiResult()
    }

    fun callApi() {
        viewModelScope.launch(CoroutineExceptionHandler { _, throwable ->
            throwable.printStackTrace()
        }) {
            val result = apiRepository.service.getQuotes()
            if (result.isSuccessful) {
                callApiResult.value = CallApiResult.ResultOk(result)
            } else {
                callApiResult.value = CallApiResult.ResultError
            }
        }
    }
}