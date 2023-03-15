package com.example.portfolioapp2.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.portfolioapp2.databinding.RowPostBinding
import com.example.portfolioapp2.dataclasses.Post

class PostsAdapter : ListAdapter<Post, PostsAdapter.PostsViewHolder>(DiffCallback()) {

    class PostsViewHolder(val binding: RowPostBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostsViewHolder {
        val binding = RowPostBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PostsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PostsViewHolder, position: Int) {
        val post = getItem(position)

        with(holder) {
            with(post) {
                binding.userId.text = this.userId.toString()
                binding.id.text = this.id.toString()
                binding.title.text = this.title
                binding.body.text = this.body
            }
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<Post>(){
        override fun areItemsTheSame(oldItem: Post, newItem: Post): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Post, newItem: Post): Boolean {
            return oldItem == newItem
        }
    }
}