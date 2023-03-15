package com.example.portfolioapp2.repositories

import com.example.portfolioapp2.dataclasses.Post
import com.example.portfolioapp2.services.RetrofitSingleton
import retrofit2.Call

interface PostsRepository {

    fun getPosts(): Call<List<Post>>

}

object PostsRepositoryImpl : PostsRepository {
    override fun getPosts(): Call<List<Post>> = RetrofitSingleton.service.getPosts()
}
