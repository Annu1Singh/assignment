package com.sundram.assignment.prenstation.adapter

import android.app.Application
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.sundram.assignment.R
import com.sundram.assignment.data.datamodel.PostsItem
import com.sundram.assignment.databinding.SinglePostItemViewBinding
import com.sundram.assignment.prenstation.ui.MainActivity
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class PostAdapter @Inject constructor() :
    RecyclerView.Adapter<PostAdapter.ViewHolder>() {

    private var context: Context? = null

    fun setContext(context: Context) {
        this.context = context
    }

    class ViewHolder(var binding: SinglePostItemViewBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.single_post_item_view,
            parent,
            false
        ) as SinglePostItemViewBinding
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.post = differ.currentList[holder.adapterPosition]
        holder.binding.main.setOnClickListener {
            onItemClickListener?.let { it1 -> it1(differ.currentList[holder.adapterPosition]) }
        }
    }


    private val callback = object : DiffUtil.ItemCallback<PostsItem>() {
        override fun areItemsTheSame(oldItem: PostsItem, newItem: PostsItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: PostsItem, newItem: PostsItem): Boolean {
            return oldItem == newItem
        }

    }


    val differ = AsyncListDiffer(this, callback)

    private var onItemClickListener: ((PostsItem) -> Unit)? = null

    fun setOnItemClickListener(listener: (PostsItem) -> Unit) {
        onItemClickListener = listener
    }

}