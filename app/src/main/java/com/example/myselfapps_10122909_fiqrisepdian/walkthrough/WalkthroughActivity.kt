package com.example.myselfapps_10122909_fiqrisepdian.walkthrough

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.myselfapps_10122909_fiqrisepdian.MainActivity
import com.example.myselfapps_10122909_fiqrisepdian.R

class WalkthroughActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager2
    private lateinit var btnNext: Button
    private lateinit var walkthroughItems: List<WalkthroughItem>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_walkthrough)

        viewPager = findViewById(R.id.viewPager)
        btnNext = findViewById(R.id.btnNext)

        // Data item halaman
        walkthroughItems = listOf(
            WalkthroughItem(
                imageRes = R.drawable.fshp1,
                title = "Selamat Datang 🎉",
                description = "Hai! Senang banget kamu ada di sini. Yuk lihat apa saja yang ada di aplikasi ini."
            ),
            WalkthroughItem(
                imageRes = R.drawable.fshp1,
                title = "Eksplorasi Seru 🚀",
                description = "Nikmati galeri keren, profil pribadi, dan catatan aktivitas harian yang seru!"
            ),
            WalkthroughItem(
                imageRes = R.drawable.fshp1,
                title = "Ayo Mulai Petualanganmu ✨",
                description = "Siap untuk menjelajah? Yuk temukan semua fitur menarik yang sudah menunggu!"
            )
        )

        val adapter = WalkthroughAdapter(walkthroughItems)
        viewPager.adapter = adapter

        // Update tombol saat halaman berpindah
        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                btnNext.text = if (position == walkthroughItems.lastIndex) "MULAI" else "NEXT"
            }
        })

        btnNext.setOnClickListener {
            val currentItem = viewPager.currentItem
            if (currentItem < walkthroughItems.lastIndex) {
                viewPager.currentItem = currentItem + 1
            } else {
                // Halaman terakhir: pindah ke MainActivity
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }
        }
    }
}
