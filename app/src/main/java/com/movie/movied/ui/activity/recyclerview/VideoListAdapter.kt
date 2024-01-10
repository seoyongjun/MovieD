package com.movie.movied.ui.activity.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import com.movie.movied.R
import com.movie.movied.data.api.common.Video
import com.movie.movied.utils.recyclerView.BaseRecyclerViewAdapter
import com.movie.movied.utils.recyclerView.BaseRecyclerViewHolder

class VideoListAdapter : BaseRecyclerViewAdapter<Video, VideoListRecyclerViewHolder>() {
    var listener: BaseRecyclerViewHolder.ItemClickListener<Video>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoListRecyclerViewHolder {
        return VideoListRecyclerViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_video_list, parent, false)
        ).apply {
            listener = this@VideoListAdapter.listener
        }
    }

}