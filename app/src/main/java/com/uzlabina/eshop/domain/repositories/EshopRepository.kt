package com.uzlabina.eshop.domain.repositories
import com.uzlabina.eshop.domain.entities.ShoppingItem


abstract class EshopRepository {
    abstract suspend fun getItems(): MutableList<ShoppingItem>
    abstract suspend fun addItem(item: ShoppingItem)
}