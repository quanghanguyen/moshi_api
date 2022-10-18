package com.example.callapi.repository

import com.example.callapi.apis.QuotesApiProvider
import com.example.callapi.apis.QuotesInterface

class ApiRepository {
    private val retrofit = QuotesApiProvider().getRetrofit()
    val service = retrofit.create(QuotesInterface::class.java)
}