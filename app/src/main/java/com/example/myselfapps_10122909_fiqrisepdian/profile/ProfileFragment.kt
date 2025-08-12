package com.example.myselfapps_10122909_fiqrisepdian.profile

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import com.example.myselfapps_10122909_fiqrisepdian.R
import com.example.myselfapps_10122909_fiqrisepdian.databinding.FragmentProfileBinding
import org.osmdroid.config.Configuration
import org.osmdroid.tileprovider.tilesource.TileSourceFactory
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.Marker

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!


    private lateinit var map: MapView
    private val lokasiRumah = GeoPoint(-6.530595574297441, 107.47371786353341)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Configuration.getInstance().load(
            requireContext(),
            requireContext().getSharedPreferences("osm_pref", Context.MODE_PRIVATE)
        )

        _binding = FragmentProfileBinding.inflate(inflater, container, false)

        map = binding.osmMapView
        map.setTileSource(TileSourceFactory.MAPNIK)
        map.setMultiTouchControls(true)
        map.controller.setZoom(17.0)
        map.controller.setCenter(lokasiRumah)
        map.controller.animateTo(lokasiRumah)

        val marker = Marker(map).apply {
            position = lokasiRumah
            setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM)
            title = "Lokasi Rumah Saya"
        }
        map.overlays.add(marker)

        map.invalidate()

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.btnCall.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:0895385635828"))
            startActivity(intent)
        }
        val fadeIn = AnimationUtils.loadAnimation(context, R.anim.fade_in)
        val slideUp = AnimationUtils.loadAnimation(context, R.anim.slide_up)
        val btnAboutApp = view.findViewById<LinearLayout>(R.id.btnAboutApp)

        btnAboutApp.setOnClickListener {
            AlertDialog.Builder(requireContext())
                .setTitle("Tentang Aplikasi")
                .setMessage("Aplikasi ini merupakan portofolio pribadi Fiqri Sepdian, berisi profil, minat, galeri, kontak, dan lokasi saya. Dibuat menggunakan Android Studio dengan bahasa pemograman kotlin dengan tampilan modern dan interaktif. MySelfApps_10122909_FiqriSepdian V.1.1")

                .setPositiveButton("Tutup", null)
                .show()
        }

        val cardProfile = view.findViewById<CardView>(R.id.cardProfile)
        val cardMinat = view.findViewById<CardView>(R.id.cardMinat)
        val cardKontak = view.findViewById<CardView>(R.id.cardKontak)
        val cardMap = view.findViewById<CardView>(R.id.cardMap)

        cardProfile.startAnimation(fadeIn)
        cardMinat.startAnimation(fadeIn)
        cardKontak.startAnimation(fadeIn)
        cardMap.startAnimation(fadeIn)

        // Tombol Email
        binding.btnEmail.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:fiqriputra789@email.com")
            }
            startActivity(intent)
        }

        // Tombol Instagram
        binding.btnInstagram.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://instagram.com/fshp.putra"))
            startActivity(intent)
        }

        // Tombol "Find Me" (Scroll ke lokasi di peta)
        binding.btnOk.setOnClickListener {
            map.controller.animateTo(lokasiRumah)
            Toast.makeText(requireContext(), "Lokasi ditampilkan di peta", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onResume() {
        super.onResume()
        map.onResume()
    }

    override fun onPause() {
        super.onPause()
        map.onPause()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
