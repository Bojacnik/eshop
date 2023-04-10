package com.uzlabina.eshop.core.domain
import arrow.core.Either

interface UseCase<out Type, in Params> {
    suspend fun call(params: Params): Either<Throwable, Type>
}
