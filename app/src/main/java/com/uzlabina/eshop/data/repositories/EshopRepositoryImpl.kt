package com.uzlabina.eshop.data.repositories

import com.uzlabina.eshop.data.datasources.EshopDataStorage
import com.uzlabina.eshop.data.models.ShoppingItemModel
import com.uzlabina.eshop.domain.entities.ShoppingItem
import com.uzlabina.eshop.domain.repositories.EshopRepository
import org.koin.java.KoinJavaComponent.inject

class EshopRepositoryImpl(): EshopRepository() {
    private val eshopDatabase: EshopDataStorage by inject(clazz = EshopDataStorage::class.java)
    override fun getItems(): MutableList<ShoppingItem>
    {
        //TODO: check this bullshit out
        return eshopDatabase.getShoppingItems().toMutableList()
    }
    override fun addItem(item: ShoppingItem){
        eshopDatabase.addShoppingItem(ShoppingItemModel(item.id, item.name, item.description, item.price, item.imageID))
    }
}