package com.uzlabina.eshop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.uzlabina.eshop.adapter.ShoppingItemAdapter
import com.uzlabina.eshop.data.ShoppingItem

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val shoppingItems = mutableListOf<ShoppingItem>()
        shoppingItems.add(ShoppingItem(0, "Počítač", 30598, R.drawable.jidl))
        shoppingItems.add(ShoppingItem(1, "Pero", 10, R.drawable.ic_launcher_background))
        shoppingItems.add(ShoppingItem(2, "Shopping cart", 3000, R.drawable.ic_baseline_shopping_cart_24))
        shoppingItems.add(ShoppingItem(2, "Shopping cart", 3000, R.drawable.ic_baseline_shopping_cart_24))
        shoppingItems.add(ShoppingItem(2, "Shopping cart", 3000, R.drawable.ic_baseline_shopping_cart_24))
        shoppingItems.add(ShoppingItem(2, "Shopping cart", 3000, R.drawable.ic_baseline_shopping_cart_24))

        val adapter = ShoppingItemAdapter(shoppingItems)
        val recyclerView = findViewById<RecyclerView>(R.id.itemRecyclerView)
        recyclerView.layoutManager = GridLayoutManager(applicationContext, 4)
        recyclerView.adapter = adapter

        val selectedItems = mutableListOf<ShoppingItem>()
        findViewById<Button>(R.id.btnBuy).setOnClickListener(View.OnClickListener {
            adapter.selectedItem?.let {
                selectedItems.add(adapter.selectedItem)
            }
        })
        findViewById<ImageButton>(R.id.btnShoppingCart).setOnClickListener(View.OnClickListener {
            val intent = Intent(this, ShoppingCartOverview::class.java)
            intent.putExtra("selectedItems", selectedItems as java.io.Serializable)
            startActivity(intent)
        })
    }


}