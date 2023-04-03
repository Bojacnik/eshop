package com.uzlabina.eshop.data.repositories

import com.uzlabina.eshop.data.datasources.EshopDataStorage
import com.uzlabina.eshop.data.datasources.EshopDatabaseHelperImpl
import com.uzlabina.eshop.data.models.ShoppingItemModel
import com.uzlabina.eshop.domain.ShoppingItem
import com.uzlabina.eshop.domain.repositories.EshopRepository
import org.koin.java.KoinJavaComponent.inject

class EshopRepositoryImpl(): EshopRepository() {
    private val eshopDatabase: EshopDataStorage by inject(clazz = EshopDataStorage::class.java)
    override suspend fun getItems(): MutableList<ShoppingItem>
    {
        return eshopDatabase.getShoppingItems().map{ it as ShoppingItem }.toMutableList()
    }
    override fun addItem(item: ShoppingItem){
        eshopDatabase.addShoppingItem(ShoppingItemModel(item.id, item.name, item.description, item.price, item.imageID))
    }
}