package com.example.myselfapps_10122909_fiqrisepdian.media

import MusicAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myselfapps_10122909_fiqrisepdian.R

class MusicFragment : Fragment() {

    private lateinit var adapter: MusicAdapter

    val musicList = listOf(
        MusicItem("Fix You", "Coldplay", R.drawable.coldplay, R.raw.fixyou),
        MusicItem("Little Piece Of Heaven", "Avenged Sevenfold", R.drawable.littlepiece, R.raw.litle),
        MusicItem("Traitor", "Olivia Rodrigo", R.drawable.traitor, R.raw.traitorr),
        MusicItem("NIKI", "You'll Be In My Heart", R.drawable.youbeinmyheart, R.raw.yoube),
        MusicItem("Linger", "The Cranberries", R.drawable.linger, R.raw.linger),
        MusicItem("Blue", "Yungkai", R.drawable.blue, R.raw.blue),
        MusicItem("Basket Case", "Greenday", R.drawable.basketcase, R.raw.basketcase),
        MusicItem("Best Friend", "Rex Orange County", R.drawable.bestfriend, R.raw.bestfriend),
        MusicItem("No Surprises", "Radiohead", R.drawable.nosurprise, R.raw.nosurprise),
        MusicItem("Jayanti", "NINA", R.drawable.jayanti, R.raw.jayanti),


    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_music, container, false)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerMusic)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        val controller = AnimationUtils.loadLayoutAnimation(requireContext(), R.anim.layout_fade_in)
        recyclerView.layoutAnimation = controller
        recyclerView.scheduleLayoutAnimation()

        adapter = MusicAdapter(requireContext(), musicList)
        recyclerView.adapter = adapter

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        adapter.releasePlayer()
    }
}
