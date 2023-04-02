package com.uzlabina.eshop.presentation.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.uzlabina.eshop.R
import com.uzlabina.eshop.presentation.adapter.ShoppingItemAdapter
import com.uzlabina.eshop.domain.ShoppingItem

class ShoppingActivity : AppCompatActivity() {

    val selectedItems = mutableListOf<ShoppingItem>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val shoppingItems = mutableListOf<ShoppingItem>()
        shoppingItems.add(ShoppingItem(0, "Počítač", null, 30598, R.drawable.jidl))
        shoppingItems.add(ShoppingItem(1, "Pero", null, 15, R.drawable.ic_launcher_background))

        val adapter = ShoppingItemAdapter(shoppingItems)
        val recyclerView = findViewById<RecyclerView>(R.id.itemRecyclerView)
        recyclerView.layoutManager = GridLayoutManager(applicationContext, 4)
        recyclerView.adapter = adapter

        findViewById<Button>(R.id.btnBuy).setOnClickListener(View.OnClickListener {
            adapter.selectedItem.let {
                selectedItems.add(adapter.selectedItem)
            }
        })
        findViewById<ImageButton>(R.id.btnShoppingCart).setOnClickListener(View.OnClickListener {
            val intent = Intent(this, ShoppingCartActivity::class.java)
            intent.putExtra("selectedItems", selectedItems as java.io.Serializable)
            startActivity(intent)
        })
    }


}