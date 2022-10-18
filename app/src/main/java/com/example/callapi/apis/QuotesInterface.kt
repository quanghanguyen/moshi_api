package com.example.callapi.apis

import com.example.callapi.model.QuoteList
import retrofit2.Response
import retrofit2.http.GET

interface QuotesInterface {
    @GET("/quotes")
    suspend fun getQuotes() : Response<QuoteList>
}