package com.uzlabina.eshop.domain.usecases

import com.uzlabina.eshop.domain.repositories.EshopRepository
import org.koin.java.KoinJavaComponent.inject

class GetShoppingItems(eshopRepository: EshopRepository) {
    val EshopRepository: EshopRepository by inject(clazz = EshopRepository::class.java)


}