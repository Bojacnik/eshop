package com.uzlabina.eshop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.uzlabina.eshop.adapter.ShoppingItemAdapter
import com.uzlabina.eshop.data.ShoppingItem

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mutableList = mutableListOf<ShoppingItem>()
        mutableList.add(ShoppingItem(0, "Počítač", 30598, R.drawable.jidl))
        mutableList.add(ShoppingItem(1, "Pero", 10, R.drawable.ic_launcher_background))
        mutableList.add(ShoppingItem(2, "Shopping cart", 3000, R.drawable.ic_baseline_shopping_cart_24))
        mutableList.add(ShoppingItem(2, "Shopping cart", 3000, R.drawable.ic_baseline_shopping_cart_24))
        mutableList.add(ShoppingItem(2, "Shopping cart", 3000, R.drawable.ic_baseline_shopping_cart_24))
        mutableList.add(ShoppingItem(2, "Shopping cart", 3000, R.drawable.ic_baseline_shopping_cart_24))
        val adapter = ShoppingItemAdapter(mutableList)
        val recyclerView = findViewById<RecyclerView>(R.id.itemRecyclerView)
        recyclerView.layoutManager = GridLayoutManager(applicationContext, 4)
        recyclerView.adapter = adapter

        findViewById<ImageButton>(R.id.btnShoppingCart).setOnClickListener(View.OnClickListener {

        })
    }


}