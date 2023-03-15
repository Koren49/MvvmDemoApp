package com.example.portfolioapp2.services

import com.example.portfolioapp2.dataclasses.Post
import retrofit2.Call
import retrofit2.http.GET

interface PostsApi {
    @GET("posts/")
    fun getPosts(): Call<List<Post>>
}