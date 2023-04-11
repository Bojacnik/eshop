package com.uzlabina.eshop.presentation.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.uzlabina.eshop.R
import com.uzlabina.eshop.domain.entities.ShoppingCart
import com.uzlabina.eshop.domain.entities.ShoppingCartImpl
import com.uzlabina.eshop.presentation.adapter.ShoppingItemAdapter
import com.uzlabina.eshop.domain.entities.ShoppingItem
import org.koin.android.ext.android.inject
import org.koin.java.KoinJavaComponent

class ShoppingCartActivity : AppCompatActivity() {
    private val shoppingCart: ShoppingCart by KoinJavaComponent.inject(clazz = ShoppingCart::class.java)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping_cart_overview)

        val adapter = KoinJavaComponent.get<ShoppingItemAdapter>(clazz = ShoppingItemAdapter::class.java)
        val recyclerView = findViewById<RecyclerView>(R.id.itemRecyclerView)
        recyclerView.layoutManager = GridLayoutManager(applicationContext, 4)
        recyclerView.adapter = adapter

        val backButton = findViewById<Button>(R.id.backButton)
        backButton.setOnClickListener {
            onBackPressed()
        }

        val sendButton = findViewById<Button>(R.id.sendButton)
        sendButton.setOnClickListener {
            TODO("Implement either sending an email with order or parse to JSON")
        }

        val removeitemButton = findViewById<Button>(R.id.btnRemoveSelected)
        removeitemButton.setOnClickListener {
            shoppingCart.removeItem(adapter.selectedItem)
            adapter.notifyDataSetChanged()
        }

        val removeitemsButton = findViewById<Button>(R.id.btnRemoveAll)
        removeitemsButton.setOnClickListener {
            shoppingCart.clearItems()
            adapter.notifyDataSetChanged()
        }

    }


}