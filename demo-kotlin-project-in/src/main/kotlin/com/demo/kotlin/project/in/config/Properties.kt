package com.demo.kotlin.project.`in`.config

class Properties {

    var mappings: Mappings = Mappings()
    var timeout: Long = 0

    class Mappings {
        lateinit var helloWorld: String
        lateinit var greeting: String
    }

}
