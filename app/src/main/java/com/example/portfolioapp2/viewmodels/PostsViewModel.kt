package com.example.portfolioapp2.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.portfolioapp2.dataclasses.Post
import com.example.portfolioapp2.enums.State
import com.example.portfolioapp2.repositories.RepoFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostsViewModel() : ViewModel() {

    // backing field
    private val _postsList = MutableLiveData<List<Post>>()
    val postsList: LiveData<List<Post>> = _postsList
    private val _state = MutableLiveData<State>()
    val state: LiveData<State> = _state

    fun getPosts() {

            _state.postValue(State.LOADING)

            RepoFactory.postsRepository.getPosts().enqueue(object : Callback<List<Post>> {

                override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                    // once we have a response, we can notify the activity with the data
                    if (response.isSuccessful) {
                        // let the state observer know that it is no longer in loading mode, but in idle mode
                        _state.postValue(State.IDLE)
                        val listOfPosts = response.body() // List of posts
                       // _postsListFromService.postValue(listOfPosts)
                        // For demonstrating purposes, let's save listsOfPosts to room DB
                        if (listOfPosts != null) {
                            CoroutineScope(Dispatchers.IO).launch {
                                RepoFactory.postsRepository.updatePosts(listOfPosts)
                                val listOfPostsFromRoom = RepoFactory.postsRepository.getPostsFromRoom()
                                _postsList.postValue(listOfPostsFromRoom)
                            }
                        }
                    } else {
                        _state.postValue(State.ERROR)
                    }
                }

                override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                    _state.postValue(State.ERROR)
                }
            })
      //  }
    }
}