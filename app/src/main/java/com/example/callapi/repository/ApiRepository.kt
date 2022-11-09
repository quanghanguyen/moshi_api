package com.example.callapi.repository

import com.example.callapi.apis.QuotesApiProvider
import com.example.callapi.apis.QuotesInterface
import com.example.callapi.model.QuoteList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ApiRepository {
//    private lateinit var apiCall : Call<QuoteList>
    private val retrofit = QuotesApiProvider().getRetrofit()
    val service = retrofit.create(QuotesInterface::class.java)

//    suspend fun callApi() {
//        apiCall = service.getQuotes()
//        apiCall.enqueue(object : Callback<QuoteList> {
//            override fun onResponse(call: Call<QuoteList>, response: Response<QuoteList>) {
//
//            }
//
//            override fun onFailure(call: Call<QuoteList>, t: Throwable) {
//
//            }
//        })
//    }
}