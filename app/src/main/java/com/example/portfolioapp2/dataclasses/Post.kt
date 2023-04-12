package com.example.portfolioapp2.dataclasses

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//data class Post(
//    val id: Int,
//    val userId: Int,
//    val title: String,
//    val body: String
//)

@Entity(tableName = "posts")
data class Post(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "user_id") val userId: Int?,
    @ColumnInfo(name = "title") val title: String?,
    @ColumnInfo(name = "body") val body: String?,

)