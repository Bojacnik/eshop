package com.uzlabina.eshop.presentation.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.uzlabina.eshop.R
import com.uzlabina.eshop.presentation.adapter.ShoppingItemAdapter
import com.uzlabina.eshop.data.models.ShoppingItemModel

class ShoppingCartActivity : AppCompatActivity() {
    lateinit var selectedItems: MutableList<ShoppingItemModel>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping_cart_overview)
        selectedItems = intent.extras?.getSerializable("selectedItems") as MutableList<ShoppingItemModel>

        val adapter = ShoppingItemAdapter(selectedItems)
        val recyclerView = findViewById<RecyclerView>(R.id.itemRecyclerView)
        recyclerView.layoutManager = GridLayoutManager(applicationContext, 4)
        recyclerView.adapter = adapter

        val backButton = findViewById<Button>(R.id.backButton)
        backButton.setOnClickListener {
            onBackPressed()
        }

        val sendButton = findViewById<Button>(R.id.sendButton)
        sendButton.setOnClickListener {
        }

        val removeitemButton = findViewById<Button>(R.id.btnRemoveSelected)
        removeitemButton.setOnClickListener {
            selectedItems.remove(adapter.selectedItem)
            TODO("Deletes it from local list, but not from MainActivity list")
            adapter.notifyDataSetChanged()
        }

        val removeitemsButton = findViewById<Button>(R.id.btnRemoveAll)
        removeitemsButton.setOnClickListener {
            selectedItems.clear()
            TODO("Deletes it from local list, but not from MainActivity list")
            adapter.notifyDataSetChanged()
        }

    }


}