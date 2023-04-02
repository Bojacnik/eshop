package com.uzlabina.eshop.data.repositories

import com.uzlabina.eshop.data.datasources.EshopDatabaseHelper
import com.uzlabina.eshop.data.models.ShoppingItemModel
import com.uzlabina.eshop.domain.ShoppingItem
import com.uzlabina.eshop.domain.repositories.EshopRepository

class EshopRepositoryImpl(databaseHelper: EshopDatabaseHelper): EshopRepository() {
    private val eshopDatabaseHelper: EshopDatabaseHelper
    init {
        eshopDatabaseHelper = databaseHelper
    }

    override suspend fun getItems(): MutableList<ShoppingItem>
    {
        return eshopDatabaseHelper.getShoppingItems().map{ it as ShoppingItem }.toMutableList()
    }

    override fun addItem(item: ShoppingItem){
        eshopDatabaseHelper.addShoppingItem(ShoppingItemModel(item.id, item.name, item.description, item.price, item.imageID))
    }
}