package com.example.myselfapps_10122909_fiqrisepdian.media

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myselfapps_10122909_fiqrisepdian.R

class VideoAdapter(private val context: Context, private val videos: List<VideoItem>) :
    RecyclerView.Adapter<VideoAdapter.VideoViewHolder>() {

    inner class VideoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageThumbnail: ImageView = view.findViewById(R.id.imageThumbnail)
        val textTitle: TextView = view.findViewById(R.id.textTitle)
        val textChannel: TextView = view.findViewById(R.id.textChannel)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_video, parent, false)
        return VideoViewHolder(view)
    }

    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        val video = videos[position]
        holder.textTitle.text = video.title
        holder.textChannel.text = video.channel

        Glide.with(context).load(video.thumbnailUrl).into(holder.imageThumbnail)

        holder.itemView.setOnClickListener {
            val activity = context as AppCompatActivity
            activity.supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, VideoPlayerFragment.newInstance(video.youtubeVideoId))
                .addToBackStack(null)
                .commit()
        }

    }

    override fun getItemCount(): Int = videos.size
}