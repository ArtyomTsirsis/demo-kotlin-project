package com.demo.kotlin.project.`in`.config

import com.demo.kotlin.project.`in`.Handler
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.RequestPredicates.GET
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.RouterFunctions.route
import org.springframework.web.reactive.function.server.ServerResponse
import java.time.Duration

@Configuration
class HandlerFunctionConfig {

    @Bean
    @ConfigurationProperties(prefix = "rest")
    fun properties(): Properties {
        return Properties()
    }

    @Bean
    fun createVirtualCardRouterFunction(
        properties: Properties,
        handler: Handler,
    ): RouterFunction<ServerResponse?>? {
        return route(
            GET(properties.mappings.greeting)
        ) { serverRequest ->
            handler.handle(serverRequest)
                .timeout(Duration.ofSeconds(properties.timeout))
        }
    }

}