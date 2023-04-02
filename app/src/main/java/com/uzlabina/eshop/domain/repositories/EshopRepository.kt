package com.uzlabina.eshop.domain.repositories
import com.uzlabina.eshop.domain.ShoppingItem


abstract class EshopRepository {
    abstract suspend fun getItems(): MutableList<ShoppingItem>
    abstract fun addItem(item: ShoppingItem)
}