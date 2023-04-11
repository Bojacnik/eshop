package com.uzlabina.eshop.domain.entities

abstract class ShoppingCart {
    companion object {
        enum class ShoppingCartState {
            SHOPPING,
            IN_SHOPPING_CART,
            REVIEW,
            PLACING_ORDER
        }
    }
    abstract fun getState(): ShoppingCartState
    abstract fun changeState(newShoppingCartState: ShoppingCartState)
    abstract fun addItem(item: ShoppingItem)
    abstract fun removeItem(item: ShoppingItem)
    abstract fun clearItems()
}

data class ShoppingCartImpl(private var state: Companion.ShoppingCartState) : ShoppingCart() {
    private val shoppingList = mutableListOf<ShoppingItem>()
    override fun getState(): Companion.ShoppingCartState {
        return state
    }
    override fun changeState(newShoppingCartState: Companion.ShoppingCartState)
    {
        state = newShoppingCartState
    }
    override fun addItem(item: ShoppingItem)
    {
        shoppingList.add(item)
    }
    override fun removeItem(item: ShoppingItem)
    {
        shoppingList.remove(item)
    }
    override fun clearItems()
    {
        shoppingList.clear()
    }
}