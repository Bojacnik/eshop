package com.uzlabina.eshop

import com.uzlabina.eshop.data.datasources.EshopDatabaseHelper
import com.uzlabina.eshop.domain.ShoppingCart

data class appimpl(
    private val EshopDatabaseHelper: EshopDatabaseHelper,
    private val ShoppingCart: ShoppingCart
    )
