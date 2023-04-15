package com.demo.kotlin.project.`in`

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/kotlin/")
class Controller() {

    @GetMapping
    fun testController(): String {
        return "Hello, World!"
    }

}