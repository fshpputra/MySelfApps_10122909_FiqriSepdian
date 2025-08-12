package com.example.myselfapps_10122909_fiqrisepdian.media

data class MusicItem(
    val title: String,
    val artist: String,
    val imageRes: Int,
    val audioRes: Int,
    var isPlaying: Boolean = false
)

