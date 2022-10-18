package com.example.callapi.apis

import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class QuotesApiProvider {

    private companion object {
        const val baseUrl : String = "https://quotable.io/"
    }

    fun getRetrofit(): Retrofit {
        val moshi = Moshi.Builder()
            .add(com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory())
            .build()
        return Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .client(getClient())
            .baseUrl(baseUrl)
            .build()
    }

    private fun getClient(): OkHttpClient {
        val logInterceptor = HttpLoggingInterceptor()
        logInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return OkHttpClient.Builder()
            .addInterceptor(logInterceptor)
            .build()
    }

//    private const val baseUrl = "https://quotable.io/"
//
//    fun getInstance(): Retrofit {
//        return Retrofit.Builder().baseUrl(baseUrl)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//    }
}