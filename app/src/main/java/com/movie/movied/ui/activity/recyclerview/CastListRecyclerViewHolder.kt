package com.movie.movied.ui.activity.recyclerview

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.movie.movied.R
import com.movie.movied.data.api.common.Cast
import com.movie.movied.utils.recyclerView.BaseRecyclerViewHolder

class CastListRecyclerViewHolder(itemView: View) : BaseRecyclerViewHolder<Cast>(itemView) {
    private val posterView: ImageView = itemView.findViewById(R.id.poster)
    private val characterView: TextView = itemView.findViewById(R.id.tvCharacter)
    private val nameView: TextView = itemView.findViewById(R.id.tvName)
    override fun bind(holder: BaseRecyclerViewHolder<Cast>, item: Cast, position: Int) {

        characterView.text = item.character
        nameView.text = item.name
        itemView.setOnClickListener {
            listener?.onClick(item, position)
        }
    }
}