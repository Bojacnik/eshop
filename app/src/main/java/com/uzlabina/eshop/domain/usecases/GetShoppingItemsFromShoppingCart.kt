package com.uzlabina.eshop.domain.usecases

import arrow.core.Either
import com.uzlabina.eshop.core.domain.UseCase
import com.uzlabina.eshop.domain.entities.ShoppingCart
import com.uzlabina.eshop.domain.entities.ShoppingItem
import org.koin.java.KoinJavaComponent

class GetShoppingItemsFromShoppingCart: UseCase<List<ShoppingItem>, Unit> {
    private val shoppingCart: ShoppingCart by KoinJavaComponent.inject(clazz = ShoppingCart::class.java)

    override suspend fun call(params: Unit): Either<Throwable, List<ShoppingItem>> {
        return try {
            Either.Right(shoppingCart.getItems())
        } catch (e: java.lang.Exception)  {
            Either.Left<Throwable>(e)
        }
    }
}
