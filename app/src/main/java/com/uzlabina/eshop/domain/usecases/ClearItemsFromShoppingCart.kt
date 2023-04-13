package com.uzlabina.eshop.domain.usecases

import arrow.core.Either
import com.uzlabina.eshop.core.domain.UseCase
import com.uzlabina.eshop.domain.entities.ShoppingCart
import org.koin.java.KoinJavaComponent

class ClearItemsFromShoppingCart: UseCase<Unit, Unit> {
    private val shoppingCart: ShoppingCart by KoinJavaComponent.inject(clazz = ShoppingCart::class.java)

    override fun call(params: Unit): Either<Throwable, Unit> {

        try {
            shoppingCart.clearItems()
        } catch (e: java.lang.Exception)
        {
            return Either.Left(e)
        }
        return Either.Right(Unit)
    }
}