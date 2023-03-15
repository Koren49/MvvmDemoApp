package com.example.portfolioapp2.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.portfolioapp2.adapters.PostsAdapter
import com.example.portfolioapp2.viewmodels.PostsViewModel
import com.example.portfolioapp2.R
import com.example.portfolioapp2.databinding.ActivityMainBinding
import com.example.portfolioapp2.enums.State
import com.example.portfolioapp2.repositories.PostsRepositoryImpl.getPosts
import com.example.portfolioapp2.utils.gone
import com.example.portfolioapp2.utils.visible
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupRecyclerView()
        setupObservers()
    }

    private fun setupRecyclerView() {
        binding.postsRecyclerView.apply {
            adapter = PostsAdapter()
            addItemDecoration(
                DividerItemDecoration(
                    this@MainActivity,
                    DividerItemDecoration.VERTICAL
                )
            )
        }
    }

    private fun setupObservers() {
        val postsViewModel: PostsViewModel by viewModels()
        postsViewModel.postsListFromService.observe(this) {
            (binding.postsRecyclerView.adapter as PostsAdapter).submitList(it)
        }
        postsViewModel.apply {
            getPosts()
            state.observe(this@MainActivity) {
                when (it) {
                    State.ERROR -> {
                        Snackbar.make(binding.rootLayout, getString(R.string.error_message), Snackbar.LENGTH_LONG)
                            .show()
                        binding.progressBar.gone()
                        // binding.progressBar.gone()
                    }
                    State.LOADING -> binding.progressBar.visible()
                    State.IDLE,
                    null -> binding.progressBar.gone()
                }

            }
        }
    }
}
