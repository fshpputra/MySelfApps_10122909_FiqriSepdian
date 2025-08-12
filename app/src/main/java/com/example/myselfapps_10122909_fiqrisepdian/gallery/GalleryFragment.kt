package com.example.myselfapps_10122909_fiqrisepdian.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myselfapps_10122909_fiqrisepdian.R

class GalleryFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_gallery, container, false)

        val imageList = listOf(
            R.drawable.foto1, R.drawable.foto4,
            R.drawable.foto2, R.drawable.foto5,
            R.drawable.foto3, R.drawable.foto6,
            R.drawable.foto7, R.drawable.foto8,
            R.drawable.foto9, R.drawable.foto10,
            R.drawable.foto11, R.drawable.foto12
        )

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerGallery)
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        recyclerView.adapter = GalleryAdapter(requireContext(), imageList)

        val controller = AnimationUtils.loadLayoutAnimation(requireContext(), R.anim.layout_slide_up) // atau layout_fade_in
        recyclerView.layoutAnimation = controller
        recyclerView.scheduleLayoutAnimation()

        return view
    }
}
