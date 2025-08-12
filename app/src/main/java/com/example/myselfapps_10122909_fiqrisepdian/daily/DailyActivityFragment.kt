package com.example.myselfapps_10122909_fiqrisepdian.daily

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.Button
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myselfapps_10122909_fiqrisepdian.R

class DailyActivityFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view = inflater.inflate(R.layout.fragment_daily_activity, container, false)

        val btnDaily = view.findViewById<Button>(R.id.btnDailyActivity)
        val btnFriends = view.findViewById<Button>(R.id.btnFriendsList)

        val recyclerDaily = view.findViewById<RecyclerView>(R.id.recyclerViewDaily)
        val recyclerFriends = view.findViewById<RecyclerView>(R.id.recyclerViewFriends)

        recyclerDaily.layoutManager = LinearLayoutManager(requireContext())
        recyclerDaily.adapter = DailyActivityAdapter(
            listOf(
                DailyActivityItem(R.drawable.ic_info, "Bekerja BackEnd Dev", "Everyday alawys ngoding yang selalu muncul error ", "8jam"),
                DailyActivityItem(R.drawable.ic_info, "Belajar/Mengerjakan Tugas", "Mengerjakan Tugas yang diberikan dosen", "3 jam"),
                DailyActivityItem(R.drawable.ic_info, "Kuliah Dimalam hari", "Mengikuti kelas daring atau tatap muka pada malam hari untuk menyelesaikan studi.", "2 jam"),
                DailyActivityItem(R.drawable.ic_info, "Refreshing", "Meluangkan waktu untuk bermain game atau jalan jalan.", "2 jam"),
                DailyActivityItem(R.drawable.ic_info, "Menonton Film", "Menonton film saat sebelum tidur.", "2 jam")
            )
        )

        recyclerFriends.layoutManager = LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
        recyclerFriends.adapter = FriendAdapter(
            listOf(
                Friend(R.drawable.fajar, "Fajar Sidik Purnama"),
                Friend(R.drawable.rana, "Rana Mulyadi"),
                Friend(R.drawable.ubed, "Rudy Lesmana"),
                Friend(R.drawable.amelia, "Amelia Gita Rahayu"),
                Friend(R.drawable.irfan, "Irfan Hakim Nugraha")
            )

        )


        btnDaily.setOnClickListener {
            recyclerDaily.visibility = View.VISIBLE
            recyclerFriends.visibility = View.GONE

            btnDaily.backgroundTintList = ContextCompat.getColorStateList(requireContext(), R.color.blue_light)
            btnFriends.backgroundTintList = ContextCompat.getColorStateList(requireContext(), R.color.grey_light)
            recyclerDaily.startAnimation(AnimationUtils.loadAnimation(requireContext(), R.anim.fade_in))
            recyclerDaily.startAnimation(AnimationUtils.loadAnimation(requireContext(), R.anim.slide_up))

            btnDaily.setTextColor(Color.BLACK)
            btnFriends.setTextColor(Color.GRAY)
        }

        btnFriends.setOnClickListener {
            recyclerDaily.visibility = View.GONE
            recyclerFriends.visibility = View.VISIBLE

            btnFriends.backgroundTintList = ContextCompat.getColorStateList(requireContext(), R.color.blue_light)
            btnDaily.backgroundTintList = ContextCompat.getColorStateList(requireContext(), R.color.grey_light)

            btnFriends.setTextColor(Color.BLACK)
            btnDaily.setTextColor(Color.GRAY)
        }
        val fadeIn = AnimationUtils.loadAnimation(context, R.anim.fade_in)
        val slideUp = AnimationUtils.loadAnimation(context, R.anim.slide_up)

        recyclerDaily.startAnimation(fadeIn)
        recyclerDaily.startAnimation(slideUp)


        return view
    }
}
