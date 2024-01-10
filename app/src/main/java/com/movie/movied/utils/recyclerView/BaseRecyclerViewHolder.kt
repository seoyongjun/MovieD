package com.movie.movied.utils.recyclerView

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseRecyclerViewHolder<Item>(itemView: View) :RecyclerView.ViewHolder(itemView) {

    interface ItemClickListener<Item> {
        fun onClick(item: Item, position: Int)
    }

    var listener: ItemClickListener<Item>? = null

    abstract fun bind(holder: BaseRecyclerViewHolder<Item>, item: Item, position: Int)
}