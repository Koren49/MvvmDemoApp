package com.example.portfolioapp2.repositories

import android.content.Context
import com.example.portfolioapp2.dataclasses.Post
import com.example.portfolioapp2.services.PostDao
import com.example.portfolioapp2.services.RetrofitSingleton
import com.example.portfolioapp2.services.RoomDatabaseSingleton
import retrofit2.Call

interface PostsRepository {

    fun getPosts(): Call<List<Post>>
    fun getPostsFromRoom(): List<Post>
    fun updatePosts(posts: List<Post>)

}

object PostsRepositoryImpl : PostsRepository {

    override fun getPosts(): Call<List<Post>> = RetrofitSingleton.service.getPosts()

    override fun getPostsFromRoom(): List<Post> {
        return RoomDatabaseSingleton.getDatabaseInstance().postDao().getAllPosts()
    }


    override fun updatePosts(posts: List<Post>) {
        val database = RoomDatabaseSingleton.getDatabaseInstance()
        val postList = database.postDao().updatePosts(posts)
    }

}
