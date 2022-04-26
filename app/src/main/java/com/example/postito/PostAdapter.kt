package com.example.postito

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.postito.databinding.RecyclerviewItemBinding


class PostAdapter(val context: Context, private val postsList: List<PostDetail>) :
    RecyclerView.Adapter<PostAdapter.ViewHolder>() {

    private lateinit var mListener: onItemClickListener

    interface onItemClickListener {
        fun onItemClicked(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener) {
        mListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            RecyclerviewItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false

            ) , mListener
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val posts = postsList[position]
        holder.bind(posts)


    }

    override fun getItemCount() = postsList.size

    inner class ViewHolder(val Binding: RecyclerviewItemBinding, listener: onItemClickListener) :
        RecyclerView.ViewHolder(Binding.root) {
        fun bind(posts: PostDetail) {
            Binding.getText.text = posts.title


        }

        init {
            Binding.root.setOnClickListener {
                listener.onItemClicked(adapterPosition)
            }
        }
    }


    }


