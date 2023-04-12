package com.example.portfolioapp2.repositories

import android.app.Application

object RepoFactory {

    lateinit var context : Application
    val postsRepository : PostsRepository = PostsRepositoryImpl
}