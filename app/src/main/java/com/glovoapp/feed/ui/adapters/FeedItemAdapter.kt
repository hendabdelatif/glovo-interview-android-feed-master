package com.glovoapp.feed

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.glovoapp.feed.model.entities.FeedItem
import kotlinx.android.synthetic.main.item.view.*


class FeedItemAdapter(var items: List<FeedItem> = arrayListOf()) :
    RecyclerView.Adapter<FeedItemAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ItemViewHolder {
        return ItemViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(items[position])
    }

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: FeedItem) = with(itemView) {
            title.text = item.title
        }
    }
}