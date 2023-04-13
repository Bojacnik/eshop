package com.uzlabina.eshop.domain.usecases

import arrow.core.Either
import com.uzlabina.eshop.core.domain.UseCase
import com.uzlabina.eshop.domain.entities.ShoppingCart
import com.uzlabina.eshop.domain.entities.ShoppingItem
import org.koin.java.KoinJavaComponent.inject

class AddItemToShoppingCart : UseCase<Unit, ShoppingItem> {
    private val shoppingCart: ShoppingCart by inject(clazz = ShoppingCart::class.java)

    override fun call(params: ShoppingItem): Either<Throwable, Unit> {
        try {
            shoppingCart.addItem(params)
        } catch (e: java.lang.Exception)  {
            return Either.Left<Throwable>(e)
        }
        return Either.Right(Unit)
    }
}