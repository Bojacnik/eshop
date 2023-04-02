package com.uzlabina.eshop.domain

open class ShoppingItem(val id: Int,
                        val name: String,
                        val description: String?,
                        val price: Int,
                        val imageID: Int) : java.io.Serializable