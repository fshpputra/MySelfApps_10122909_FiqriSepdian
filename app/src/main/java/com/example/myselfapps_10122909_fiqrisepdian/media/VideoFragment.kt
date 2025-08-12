package com.example.myselfapps_10122909_fiqrisepdian.media

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myselfapps_10122909_fiqrisepdian.R

class VideoFragment : Fragment() {

    private val videoList = listOf(
        VideoItem(
            "Intro to Backend Development with Node.js",
            "freeCodeCamp.org",
            "https://img.youtube.com/vi/Oe421EPjeBE/hqdefault.jpg",
            "Oe421EPjeBE"
        ),
        VideoItem(
            "Spring Boot Tutorial for Beginners",
            "Amigoscode",
            "https://img.youtube.com/vi/9SGDpanrc8U/hqdefault.jpg",
            "9SGDpanrc8U"
        ),
        VideoItem(
            "Building REST APIs with Django Rest Framework",
            "Traversy Media",
            "https://img.youtube.com/vi/B38aDwUpcFc/hqdefault.jpg",
            "B38aDwUpcFc"
        ),
        VideoItem(
            "PostgreSQL Crash Course",
            "Programming with Mosh",
            "https://img.youtube.com/vi/qw--VYLpxG4/hqdefault.jpg",
            "qw--VYLpxG4"
        ),
        VideoItem(
            "Understanding Microservices Architecture",
            "TechWorld with Nana",
            "https://img.youtube.com/vi/rv4LlmLmVWk/hqdefault.jpg",
            "rv4LlmLmVWk"
        )
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_music, container, false)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerMusic)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = VideoAdapter(requireContext(), videoList)
        val controller = AnimationUtils.loadLayoutAnimation(requireContext(), R.anim.layout_fade_in)
        recyclerView.layoutAnimation = controller
        recyclerView.scheduleLayoutAnimation()

        return view
    }

}
