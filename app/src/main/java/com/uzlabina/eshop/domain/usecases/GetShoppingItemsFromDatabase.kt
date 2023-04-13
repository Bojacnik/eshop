package com.uzlabina.eshop.domain.usecases

import arrow.core.Either
import com.uzlabina.eshop.core.domain.UseCase
import com.uzlabina.eshop.domain.entities.ShoppingItem
import com.uzlabina.eshop.domain.repositories.EshopRepository
import org.koin.java.KoinJavaComponent.inject

class GetShoppingItemsFromDatabase(): UseCase<List<ShoppingItem>, Unit> {
    private val eshopRepository: EshopRepository by inject(clazz = EshopRepository::class.java)

    override fun call(params: Unit): Either<Throwable, List<ShoppingItem>> {

        val items: List<ShoppingItem>
        try {
            items = eshopRepository.getItems()
        } catch (e: java.lang.Exception)
        {
            return Either.Left<Throwable>(e)
        }
        return Either.Right<List<ShoppingItem>>(items)
    }
}