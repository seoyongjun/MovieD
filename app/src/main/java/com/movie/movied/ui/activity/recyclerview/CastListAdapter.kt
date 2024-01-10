package com.movie.movied.ui.activity.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import com.movie.movied.R
import com.movie.movied.data.api.common.Cast
import com.movie.movied.utils.recyclerView.BaseRecyclerViewAdapter
import com.movie.movied.utils.recyclerView.BaseRecyclerViewHolder

class CastListAdapter : BaseRecyclerViewAdapter<Cast, CastListRecyclerViewHolder>() {
    var listener: BaseRecyclerViewHolder.ItemClickListener<Cast>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CastListRecyclerViewHolder {
        return CastListRecyclerViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_cast_list, parent, false)
        ).apply {
            listener = this@CastListAdapter.listener
        }
    }

}