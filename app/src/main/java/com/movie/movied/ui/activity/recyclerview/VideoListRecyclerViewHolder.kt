package com.movie.movied.ui.activity.recyclerview

import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.movie.movied.R
import com.movie.movied.data.api.common.Video
import com.movie.movied.data.api.tmbd.YOUTUBE_IMAGE_URL
import com.movie.movied.utils.recyclerView.BaseRecyclerViewHolder

class VideoListRecyclerViewHolder(itemView: View) : BaseRecyclerViewHolder<Video>(itemView) {
    private val posterView: ImageView = itemView.findViewById(R.id.poster)
    override fun bind(holder: BaseRecyclerViewHolder<Video>, item: Video, position: Int) {

        Glide.with(itemView)
            .load(item.key?.let { loadThumbnail(it) })
            .transform(CenterCrop())
            .into(posterView)

        itemView.setOnClickListener {
            listener?.onClick(item, position)
        }
    }

    private fun loadThumbnail(videoId: String): String {
        return "$YOUTUBE_IMAGE_URL$videoId/0.jpg"
    }
}