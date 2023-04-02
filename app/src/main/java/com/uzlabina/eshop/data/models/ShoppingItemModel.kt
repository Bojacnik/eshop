package com.uzlabina.eshop.data.models

import com.uzlabina.eshop.domain.ShoppingItem

class ShoppingItemModel(id: Int,
                        name: String,
                        description: String?,
                        price: Int,
                        imageID: Int) : ShoppingItem(id, name, description, price, imageID)