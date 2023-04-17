package com.demo.kotlin.project.app

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(scanBasePackages = ["com.demo.kotlin.project"])
class DemoKotlinProjectApplication

fun main(args: Array<String>) {
	runApplication<DemoKotlinProjectApplication>(*args)
}
