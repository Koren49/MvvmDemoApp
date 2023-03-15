package com.example.portfolioapp2.services

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitSingleton {
    private const val BASE_URL= "https://jsonplaceholder.typicode.com/"

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service: PostsApi = retrofit.create(PostsApi::class.java)
}
