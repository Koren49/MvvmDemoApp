package com.example.portfolioapp2.repositories

import com.example.portfolioapp2.dataclasses.Post
import com.example.portfolioapp2.services.RetrofitSingleton
import com.example.portfolioapp2.services.RoomDatabaseSingleton
import retrofit2.Call

// This is what we expose to the caller of the repository (ViewModel usually)
interface PostsRepository {

    fun getPosts(): Call<List<Post>>
    fun getPostsFromRoom(): List<Post>
    fun updatePosts(posts: List<Post>)

}

// This can include private functions that are not exposed to the caller of the repository (ViewModel usually)
object PostsRepositoryImpl : PostsRepository {

    override fun getPosts(): Call<List<Post>> = RetrofitSingleton.service.getPosts()

    override fun getPostsFromRoom(): List<Post> = RoomDatabaseSingleton.getDatabaseInstance().postDao().getAllPosts()

    override fun updatePosts(posts: List<Post>) {
        val database = RoomDatabaseSingleton.getDatabaseInstance()
        database.postDao().updatePosts(posts)
    }

}
