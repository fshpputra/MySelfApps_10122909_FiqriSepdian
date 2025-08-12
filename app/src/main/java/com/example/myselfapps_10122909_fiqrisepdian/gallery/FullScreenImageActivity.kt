package com.example.myselfapps_10122909_fiqrisepdian.gallery

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.myselfapps_10122909_fiqrisepdian.R

class FullScreenImageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_full_screen_image)

        val viewPager = findViewById<ViewPager2>(R.id.viewPager)

        val imageList = intent.getIntegerArrayListExtra("images") ?: arrayListOf()
        val startPosition = intent.getIntExtra("position", 0)

        val adapter = FullScreenImageAdapter(this, imageList)
        viewPager.adapter = adapter
        viewPager.setCurrentItem(startPosition, false)
    }
}
