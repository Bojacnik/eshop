package com.uzlabina.eshop.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.uzlabina.eshop.data.shoppingItem

class MyAdapter(private val items: List<shoppingItem>) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    // Create the ViewHolder for the RecyclerView items
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(R.id.textView)
    }

    // Inflate the item layout and return a new ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ViewHolder(view)
    }

    // Set the values of the ViewHolder's views based on the item at the given position
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = items[position].to
    }

    // Return the size of the items list
    override fun getItemCount(): Int {
        return items.size
    }
}