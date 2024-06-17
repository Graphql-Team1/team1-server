package com.sopt.team1.common

import graphql.GraphQLError
import graphql.schema.DataFetchingEnvironment
import jakarta.persistence.EntityNotFoundException
import org.springframework.graphql.execution.DataFetcherExceptionResolverAdapter
import org.springframework.graphql.execution.ErrorType
import org.springframework.stereotype.Component

@Component
class CustomExceptionResolver : DataFetcherExceptionResolverAdapter() {
    override fun resolveToSingleError(ex: Throwable, env: DataFetchingEnvironment): GraphQLError? {
        if(ex is EntityNotFoundException){
            return GraphQLError.newError().errorType(ErrorType.NOT_FOUND).message(ex.message).build()
        }
        if(ex is IllegalArgumentException){
            return GraphQLError.newError().errorType(ErrorType.BAD_REQUEST).message(ex.message).build()
        }
        return super.resolveToSingleError(ex, env)
    }
}