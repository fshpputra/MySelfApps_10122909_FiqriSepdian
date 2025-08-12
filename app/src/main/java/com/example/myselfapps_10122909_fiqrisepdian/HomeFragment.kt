package com.example.myselfapps_10122909_fiqrisepdian

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment

class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val slideUp = AnimationUtils.loadAnimation(requireContext(), R.anim.slide_up)

        view.findViewById<View>(R.id.profileCard)?.startAnimation(slideUp)
        view.findViewById<View>(R.id.minatCard)?.startAnimation(slideUp)
        view.findViewById<View>(R.id.quoteCard)?.startAnimation(slideUp)
    }
}
