import android.content.Context
import android.media.MediaPlayer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.myselfapps_10122909_fiqrisepdian.R
import com.example.myselfapps_10122909_fiqrisepdian.media.MusicItem

class MusicAdapter(
    private val context: Context,
    private val items: List<MusicItem>
) : RecyclerView.Adapter<MusicAdapter.MusicViewHolder>() {

    private var mediaPlayer: MediaPlayer? = null
    private var currentPlayingPosition = -1
    private var isPaused = false

    inner class MusicViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val img: ImageView = view.findViewById(R.id.imageAlbum)
        val title: TextView = view.findViewById(R.id.textTitle)
        val artist: TextView = view.findViewById(R.id.textArtist)
        val btnPlayPause: ImageView = view.findViewById(R.id.btnPlay)

        init {
            btnPlayPause.setOnClickListener {
                val position = adapterPosition
                val item = items[position]

                if (currentPlayingPosition == position) {
                    if (mediaPlayer?.isPlaying == true) {
                        mediaPlayer?.pause()
                        isPaused = true
                        item.isPlaying = false
                    } else if (isPaused) {
                        mediaPlayer?.start()
                        isPaused = false
                        item.isPlaying = true
                    }
                    notifyItemChanged(position)
                } else {
                    // Memutar lagu baru
                    releasePlayer()
                    mediaPlayer = MediaPlayer.create(context, item.audioRes)
                    mediaPlayer?.start()
                    currentPlayingPosition = position
                    isPaused = false

                    items.forEach { it.isPlaying = false } // reset semua
                    item.isPlaying = true

                    notifyDataSetChanged()

                    mediaPlayer?.setOnCompletionListener {
                        item.isPlaying = false
                        currentPlayingPosition = -1
                        notifyItemChanged(position)
                    }
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_music, parent, false)
        return MusicViewHolder(view)
    }

    override fun onBindViewHolder(holder: MusicViewHolder, position: Int) {
        val item = items[position]
        holder.img.setImageResource(item.imageRes)
        holder.title.text = item.title
        holder.artist.text = item.artist

        // Ganti ikon berdasarkan status
        if (item.isPlaying) {
            holder.btnPlayPause.setImageResource(R.drawable.ic_pause)
        } else {
            holder.btnPlayPause.setImageResource(R.drawable.ic_play)
        }
    }

    override fun getItemCount(): Int = items.size

    fun releasePlayer() {
        mediaPlayer?.release()
        mediaPlayer = null
        if (currentPlayingPosition != -1) {
            items[currentPlayingPosition].isPlaying = false
            notifyItemChanged(currentPlayingPosition)
        }
        currentPlayingPosition = -1
        isPaused = false
    }
}
