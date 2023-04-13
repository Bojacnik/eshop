package com.uzlabina.eshop.core.domain
import arrow.core.Either

interface UseCase<out Type, in Params> {
    fun call(params: Params): Either<Throwable, Type>
}
