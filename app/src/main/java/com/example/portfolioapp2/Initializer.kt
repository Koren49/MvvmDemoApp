package com.example.portfolioapp2

import android.app.Application
import com.example.portfolioapp2.repositories.RepoFactory

object Initializer {
    fun init (application: Application) {
        RepoFactory.context = application
    }
}