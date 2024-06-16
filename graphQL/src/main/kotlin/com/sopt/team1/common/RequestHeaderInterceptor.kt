package com.sopt.team1.common

import org.springframework.graphql.server.WebGraphQlInterceptor
import org.springframework.graphql.server.WebGraphQlRequest
import org.springframework.graphql.server.WebGraphQlResponse
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono

@Component
class RequestHeaderInterceptor : WebGraphQlInterceptor {
    override fun intercept(request: WebGraphQlRequest, chain: WebGraphQlInterceptor.Chain): Mono<WebGraphQlResponse> {
        val value = request.headers.getFirst("user-id")
        request.configureExecutionInput { executionInput, builder ->
            builder.graphQLContext(mapOf("user-id" to value)).build()
        }
        return chain.next(request)
    }
}
