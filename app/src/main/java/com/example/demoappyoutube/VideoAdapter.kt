package com.example.demoappyoutube

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.demoappyoutube.databinding.DetailVideoBinding

class VideoAdapter : PagingDataAdapter<MyArticle, VideoAdapter.VideoViewHolder>(
    object : DiffUtil.ItemCallback<MyArticle>() {
        override fun areItemsTheSame(oldItem: MyArticle, newItem: MyArticle): Boolean =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: MyArticle, newItem: MyArticle): Boolean =
            oldItem == newItem
    }
) {

    inner class VideoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = DetailVideoBinding.bind(view)

        var name: TextView = view.findViewById(R.id.more)
        var author: TextView = view.findViewById(R.id.author)
        var views: TextView = view.findViewById(R.id.viewers)
        var date: TextView = view.findViewById(R.id.date)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        return VideoViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.detail_video, parent, false)
        )
    }

    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        getItem(position)?.let {
            holder.name.text = it.userName
            holder.author.text = it.email
            //Glide
            Glide
                .with(holder.itemView.context)
                .load(it.avatar)
                .centerCrop()
                .into(holder.binding.mainVideo)
        }

    }
}