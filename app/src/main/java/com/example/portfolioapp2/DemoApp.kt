package com.example.portfolioapp2

import android.app.Application

class DemoApp: Application() {

    override fun onCreate() {
        Initializer.init(this)
        super.onCreate()
    }
}