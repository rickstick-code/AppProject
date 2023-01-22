package com.example.justplanit

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("/advice")
    fun getAdvice(): Call<Advice>
}
