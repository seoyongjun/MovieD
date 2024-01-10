package com.movie.movied.utils.recyclerView

import androidx.recyclerview.widget.RecyclerView

abstract class BaseRecyclerViewAdapter<Item, VH: BaseRecyclerViewHolder<Item>> :
    RecyclerView.Adapter<VH>() {

    private val itemList: MutableList<Item> = arrayListOf()
    override fun getItemCount() = itemList.size

    fun add(item: Item) {
        itemList.add(item)
        notifyItemChanged(itemCount -1)
    }

    fun remove(item: Item) {
        val index = itemList.indexOf(item)
        itemList.remove(item)
        notifyItemRemoved(index)
    }

    fun set(list: List<Item>) {
        val beforeSize = itemCount
        val afterSize = list.size
        val gap = beforeSize - afterSize
        if (gap > 0) {
            notifyItemRangeRemoved(afterSize, gap)
        }
        itemList.clear()
        itemList.addAll(list)
        notifyItemRangeChanged(0, itemCount)
    }

    private fun getItem(position: Int) = itemList[position]
    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(holder, getItem(position), position)
    }
}
