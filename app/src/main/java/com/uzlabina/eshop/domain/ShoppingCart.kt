package com.uzlabina.eshop.domain

data class ShoppingCart(private var state: ShoppingCartState, private val shoppingList: MutableList<ShoppingItem>) {

    companion object {
        enum class ShoppingCartState {
            SHOPPING,
            IN_SHOPPING_CART,
            REVIEW,
            PLACING_ORDER
        }
    }

    fun GetState(): ShoppingCartState {
        return state
    }

    fun ChangeState(newShoppingCartState: ShoppingCartState)
    {
        state = newShoppingCartState
    }

    fun AddItem(item: ShoppingItem)
    {
        shoppingList.add(item)
    }

    fun RemoveItem(item: ShoppingItem)
    {
        shoppingList.remove(item)
    }

    fun ClearShoppingCart()
    {
        shoppingList.clear()
    }
}