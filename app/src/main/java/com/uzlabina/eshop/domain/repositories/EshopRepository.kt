package com.uzlabina.eshop.domain.repositories
import com.uzlabina.eshop.domain.entities.ShoppingItem


abstract class EshopRepository {
    abstract fun getItems(): MutableList<ShoppingItem>
    abstract fun addItem(item: ShoppingItem)
}