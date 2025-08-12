package com.example.myselfapps_10122909_fiqrisepdian.daily

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myselfapps_10122909_fiqrisepdian.R

class DailyActivityAdapter(private val items: List<DailyActivityItem>) :
    RecyclerView.Adapter<DailyActivityAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val icon: ImageView = view.findViewById(R.id.imageIcon)
        val title: TextView = view.findViewById(R.id.textTitle)
        val description: TextView = view.findViewById(R.id.textDescription)
        val duration: TextView = view.findViewById(R.id.textDuration)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_daily_activity, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.icon.setImageResource(item.iconResId)
        holder.title.text = item.title
        holder.description.text = item.description
        holder.duration.text = item.duration
    }

    override fun getItemCount(): Int = items.size
}
