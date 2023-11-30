package com.demo.kotlin.project.`in`.config

import com.demo.kotlin.project.`in`.Handler
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.coRouter

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
    ) = coRouter { GET(properties.mappings.greeting, handler::handle) }

}