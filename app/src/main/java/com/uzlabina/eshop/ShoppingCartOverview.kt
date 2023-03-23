package com.uzlabina.eshop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.uzlabina.eshop.adapter.ShoppingItemAdapter
import com.uzlabina.eshop.data.ShoppingItem

class ShoppingCartOverview : AppCompatActivity() {
    private lateinit var selectedItems: MutableList<ShoppingItem>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping_cart_overview)
        selectedItems = intent.extras?.getSerializable("selectedItems") as MutableList<ShoppingItem>

        val adapter = ShoppingItemAdapter(selectedItems)
        val recyclerView = findViewById<RecyclerView>(R.id.itemRecyclerView)
        recyclerView.layoutManager = GridLayoutManager(applicationContext, 4)
        recyclerView.adapter = adapter

        val backButton = findViewById<Button>(R.id.backButton)
        backButton.setOnClickListener(View.OnClickListener {
            onBackPressed()
        })

    }


}