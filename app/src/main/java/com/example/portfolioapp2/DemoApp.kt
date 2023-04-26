package com.example.portfolioapp2

import android.app.Application

/**
 * Getting called automatically when app starts
 */
class DemoApp: Application() {

    override fun onCreate() {
        Initializer.init(this)
        super.onCreate()
    }
}