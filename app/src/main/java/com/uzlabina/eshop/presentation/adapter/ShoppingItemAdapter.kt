package com.uzlabina.eshop.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import arrow.core.left
import arrow.core.right
import com.uzlabina.eshop.R
import com.uzlabina.eshop.domain.entities.ShoppingItem
import com.uzlabina.eshop.domain.usecases.GetShoppingItemsFromDatabase
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking

class ShoppingItemAdapter() : RecyclerView.Adapter<ShoppingItemAdapter.ViewHolder>() {

    private lateinit var items: List<ShoppingItem>
    lateinit var selectedItem: ShoppingItem

    // Create the ViewHolder for the RecyclerView items
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val container: ConstraintLayout = itemView.findViewById(R.id.layout)
        val imageViewItemPicture: ImageView = itemView.findViewById(R.id.image)
        val textViewName: TextView = itemView.findViewById(R.id.name)
        val textViewPrice: TextView = itemView.findViewById(R.id.price)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var itemLoading = runBlocking{
            async {
                val databaseItems = GetShoppingItemsFromDatabase().call(Unit)
                TODO("NOT FINISHED")
                if (databaseItems.isLeft())
                {
                }
            }
        }


        val view = LayoutInflater.from(parent.context).inflate(R.layout.shopping_item, parent, false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.imageViewItemPicture.setImageResource(items[position].imageID)
        holder.textViewName.text = items[position].name
        holder.textViewPrice.text = items[position].price.toString() + " Kč"

        holder.container.setOnClickListener {
            selectedItem = items[position]
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}