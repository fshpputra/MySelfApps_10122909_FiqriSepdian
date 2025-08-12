package com.example.myselfapps_10122909_fiqrisepdian.walkthrough

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.myselfapps_10122909_fiqrisepdian.R

class WalkthroughFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_walkthrough, container, false)

        val viewPager: ViewPager2 = view.findViewById(R.id.viewPagerWalkthrough)

        val items = listOf(
            WalkthroughItem(
                imageRes =R.drawable.fshp1,
                title = "Selamat Datang",
                description = "Kenali aplikasi portofolio pribadi Fiqri!"
            ),
            WalkthroughItem(
                imageRes = R.drawable.fshp1,
                title = "Fitur Lengkap",
                description = "Lihat daily activity, galeri, dan profil saya."
            ),
            WalkthroughItem(
                imageRes = R.drawable.fshp1,
                title = "Mulai Sekarang",
                description = "Ayo jelajahi aplikasi sekarang!"
            )
        )

        val adapter = WalkthroughAdapter(items)
        viewPager.adapter = adapter


        return view
    }
}
