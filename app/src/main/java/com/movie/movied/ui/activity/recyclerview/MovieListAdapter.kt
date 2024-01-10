package com.movie.movied.ui.activity.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import com.movie.movied.R
import com.movie.movied.data.api.common.MovieData
import com.movie.movied.utils.recyclerView.BaseRecyclerViewAdapter
import com.movie.movied.utils.recyclerView.BaseRecyclerViewHolder

class MovieListAdapter : BaseRecyclerViewAdapter<MovieData, MovieListRecyclerViewHolder>() {
    var listener: BaseRecyclerViewHolder.ItemClickListener<MovieData>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieListRecyclerViewHolder {
        return MovieListRecyclerViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_movie_list, parent, false)
        ).apply {
            listener = this@MovieListAdapter.listener
        }
    }

}