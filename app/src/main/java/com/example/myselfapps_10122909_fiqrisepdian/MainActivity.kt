package com.example.myselfapps_10122909_fiqrisepdian
/*
    * Nama     : Fiqri Sepdian Hermawan Putra
    * NIM      : 10122909
    * Kelas    : IF-13k
    * */
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.example.myselfapps_10122909_fiqrisepdian.daily.DailyActivityFragment
import com.example.myselfapps_10122909_fiqrisepdian.gallery.GalleryFragment
import com.example.myselfapps_10122909_fiqrisepdian.media.MediaFragment
import com.example.myselfapps_10122909_fiqrisepdian.profile.ProfileFragment


class MainActivity : AppCompatActivity() {

    private lateinit var bottomNavigationView: BottomNavigationView


    override fun onCreate(savedInstanceState: Bundle?) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigationView = findViewById(R.id.bottomNavigation)

        // Tampilkan HomeFragment pertama kali
        loadFragment(HomeFragment())

        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menu_home -> loadFragment(HomeFragment())
                R.id.menu_daily -> loadFragment(DailyActivityFragment())
                R.id.menu_gallery -> loadFragment(GalleryFragment())
                R.id.menu_profile -> loadFragment(ProfileFragment())
                R.id.menu_media -> loadFragment(MediaFragment())
                else -> false
            }
        }
    }

    private fun loadFragment(fragment: Fragment): Boolean {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
        return true
    }

}