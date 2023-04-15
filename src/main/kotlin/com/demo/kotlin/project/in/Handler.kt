package com.demo.kotlin.project.`in`

import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.HandlerFunction
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono

@Component
class Handler : HandlerFunction<ServerResponse> {
    override fun handle(request: ServerRequest): Mono<ServerResponse> {
        return Mono.fromSupplier { request.queryParam("greeting") }
            .map { greet -> greet.get() }
            .flatMap { greet -> ServerResponse.ok().bodyValue(greet) }
    }


}