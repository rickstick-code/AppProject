package com.example.justplanit

import com.squareup.moshi.Moshi
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.converter.moshi.MoshiConverterFactory


object AdviceApi {
    val retrofit: Retrofit
    val retrofitService: ApiInterface
    init {
        val moshi = Moshi.Builder().build()
        retrofit = Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl("https://api.adviceslip.com")
            .build()
        retrofitService = retrofit.create(ApiInterface::class.java)
    }
}

interface ApiInterface {
    @GET("/advice")
    fun getAdvice(): Call<Slip>
}
