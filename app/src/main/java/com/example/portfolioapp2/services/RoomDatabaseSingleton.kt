package com.example.portfolioapp2.services

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.portfolioapp2.dataclasses.Post
import com.example.portfolioapp2.repositories.RepoFactory

@Database(entities = [Post::class], version = 1)
abstract class RoomDatabaseSingleton() : RoomDatabase() {
     abstract fun postDao(): PostDao

    companion object {
        private var databaseInstance: RoomDatabaseSingleton? = null

        fun getDatabaseInstance(): RoomDatabaseSingleton {
            return if (databaseInstance == null) {
                databaseInstance = Room.databaseBuilder(
                    RepoFactory.context,
                    RoomDatabaseSingleton::class.java, "app_data_base"
                ).build()

                databaseInstance!!
            } else {
                databaseInstance!!
            }
        }
    }

}
