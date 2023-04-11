package com.uzlabina.eshop.presentation.activity

import kotlinx.coroutines.*
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.uzlabina.eshop.R
import com.uzlabina.eshop.data.datasources.EshopDataStorage
import com.uzlabina.eshop.data.datasources.EshopDatabaseHelperImpl
import com.uzlabina.eshop.data.repositories.EshopRepositoryImpl
import com.uzlabina.eshop.domain.entities.ShoppingCart
import com.uzlabina.eshop.domain.entities.ShoppingCartImpl
import com.uzlabina.eshop.presentation.adapter.ShoppingItemAdapter
import com.uzlabina.eshop.domain.entities.ShoppingItem
import com.uzlabina.eshop.domain.repositories.EshopRepository
import com.uzlabina.eshop.domain.usecases.AddShoppingItemToDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.module
import org.koin.java.KoinJavaComponent

class ShoppingActivity : AppCompatActivity() {

    private val shoppingCart: ShoppingCart by KoinJavaComponent.inject(clazz = ShoppingCart::class.java)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //init of dependency injection
        startKoin {
            androidContext(this@ShoppingActivity)
            modules(module {
                single<EshopDataStorage> {  EshopDatabaseHelperImpl(this@ShoppingActivity) }
                single<EshopRepository> { EshopRepositoryImpl() }
                single<ShoppingCart> { ShoppingCartImpl(ShoppingCart.Companion.ShoppingCartState.SHOPPING) }
                single<ShoppingItemAdapter> { ShoppingItemAdapter() }
            })
        }
        val shoppingItems = mutableListOf<ShoppingItem>()
        shoppingItems.add(ShoppingItem(0, "Počítač", null, 30598, R.drawable.jidl))
        shoppingItems.add(ShoppingItem(1, "Pero", null, 15, R.drawable.ic_launcher_background))

        val addShoppingItemToDatabase = AddShoppingItemToDatabase()

        runBlocking {
            val result = async {
                addShoppingItemToDatabase.call(shoppingItems[0])
                addShoppingItemToDatabase.call(shoppingItems[1])
            }
            if (result.await().isLeft())
                throw Exception("Chyba v přidávání itemů do databáze při startu ShoppingActivity!")
        }

        val adapter = KoinJavaComponent.get<ShoppingItemAdapter>(clazz = ShoppingItemAdapter::class.java)
        val recyclerView = findViewById<RecyclerView>(R.id.itemRecyclerView)
        recyclerView.layoutManager = GridLayoutManager(applicationContext, 4)
        recyclerView.adapter = KoinJavaComponent.get<ShoppingItemAdapter>(clazz = ShoppingItemAdapter::class.java)

        findViewById<Button>(R.id.btnBuy).setOnClickListener {
            adapter.selectedItem.let {
                shoppingCart.addItem(adapter.selectedItem)
            }
        }
        findViewById<ImageButton>(R.id.btnShoppingCart).setOnClickListener {
            val intent = Intent(this, ShoppingCartActivity::class.java)
            shoppingCart.changeState(ShoppingCart.Companion.ShoppingCartState.SHOPPING)
            //TODO: I suspect that if the user clicks back the states will break but not sure
            startActivity(intent)
        }
    }


}