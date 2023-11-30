package com.demo.kotlin.project.`in`

import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.bodyValueAndAwait

@Component
class Handler {

    suspend fun handle(request: ServerRequest): ServerResponse {
        val param = request.queryParam("greeting").get()
        return ServerResponse.ok().bodyValueAndAwait(param)
    }

}