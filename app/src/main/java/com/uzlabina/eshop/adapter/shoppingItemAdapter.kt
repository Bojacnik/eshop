package com.uzlabina.eshop.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.uzlabina.eshop.R
import com.uzlabina.eshop.data.ShoppingItem

class ShoppingItemAdapter(private val items: MutableList<ShoppingItem>) : RecyclerView.Adapter<ShoppingItemAdapter.ViewHolder>() {

    // Create the ViewHolder for the RecyclerView items
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageViewItemPicture: ImageView = itemView.findViewById(R.id.image)
        val textViewName: TextView = itemView.findViewById(R.id.name)
        val textViewPrice: TextView = itemView.findViewById(R.id.price)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.shopping_item, parent, false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.imageViewItemPicture.setImageResource(items[position].imageID)
        holder.textViewName.text = items[position].name
        holder.textViewPrice.text = items[position].price.toString() + " Kč"
    }

    override fun getItemCount(): Int {
        return items.size
    }
}