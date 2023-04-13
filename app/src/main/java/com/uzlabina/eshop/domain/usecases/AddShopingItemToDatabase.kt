package com.uzlabina.eshop.domain.usecases

import arrow.core.Either
import com.uzlabina.eshop.core.domain.UseCase
import com.uzlabina.eshop.domain.entities.ShoppingCart
import com.uzlabina.eshop.domain.entities.ShoppingItem
import com.uzlabina.eshop.domain.repositories.EshopRepository
import org.koin.java.KoinJavaComponent

class AddShoppingItemToDatabase: UseCase<Unit, ShoppingItem> {
    private val repository: EshopRepository by KoinJavaComponent.inject(clazz = EshopRepository::class.java)

    override suspend fun call(params: ShoppingItem): Either<Throwable, Unit> {
        try {
            repository.addItem(params)
        } catch (e: java.lang.Exception) {
            return Either.Left<Throwable>(e)
        }
        return Either.Right(Unit)
    }
}