package com.example.portfolioapp2.repositories

import android.app.Application

object RepoFactory {

    // Get initialized in the Initializer object, that is getting called by DemoApp
    lateinit var context : Application

    val postsRepository : PostsRepository = PostsRepositoryImpl
}