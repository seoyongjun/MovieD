package com.movie.movied.ui.activity.recyclerview

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.movie.movied.R
import com.movie.movied.data.api.common.MovieData
import com.movie.movied.data.api.tmbd.IMAGE_BASE_URL
import com.movie.movied.utils.recyclerView.BaseRecyclerViewHolder

class MovieListRecyclerViewHolder(itemView: View) : BaseRecyclerViewHolder<MovieData>(itemView) {
    private val posterView: ImageView = itemView.findViewById(R.id.poster)
    private val titleView: TextView = itemView.findViewById(R.id.title)
    private val rankView: TextView = itemView.findViewById(R.id.rank)
    override fun bind(holder: BaseRecyclerViewHolder<MovieData>, item: MovieData, position: Int) {
        Glide.with(itemView)
            .load(IMAGE_BASE_URL+item.poster_path)
            .transform(CenterCrop())
            .into(posterView)

        titleView.text = item.title
        rankView.text = (position + 1).toString()
        itemView.setOnClickListener {
            listener?.onClick(item, position)
        }
    }
}