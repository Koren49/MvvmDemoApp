package com.example.portfolioapp2.services
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.portfolioapp2.dataclasses.Post

@Dao
interface PostDao {

    @Query("SELECT * FROM posts")
    fun getAllPosts(): List<Post>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPost(post: Post)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun updatePosts(postList: List<Post>)
    //
    @Delete
    fun delete(post: Post)
}