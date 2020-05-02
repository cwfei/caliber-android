package com.caliber.app.ui.watch

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.caliber.app.R
import com.caliber.app.model.Watch
import kotlinx.android.synthetic.main.item_watch.view.*

class WatchesAdapter : RecyclerView.Adapter<WatchesAdapter.ViewHolder>() {

    var items: List<Watch> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WatchesAdapter.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_watch, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: WatchesAdapter.ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(item: Watch) = with(itemView) {
            modelTextView.text = item.model
        }
    }
}