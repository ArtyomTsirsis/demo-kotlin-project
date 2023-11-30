package com.demo.kotlin.project.`in`

import com.demo.kotlin.project.domain.Task1Command
import com.demo.kotlin.project.task1.Task1Service
import lombok.extern.slf4j.Slf4j
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import reactor.core.publisher.Mono
import java.io.BufferedReader
import java.io.File

@Slf4j
@RestController
@RequestMapping("/kotlin/task/")
class Controller(private val task1Service: Task1Service) {

    @GetMapping
    fun testController(): String {
        return "Hello, World!"
    }

    @PostMapping("file")
    fun uploadFile(@RequestPart("file") uploaded: Mono<MultipartFile>): String {
//        lateinit var file: File
//
//        uploaded.map { f -> file.writeBytes(f.bytes) }
//            .map {  }
//        return "file uploaded"

        var file: MultipartFile = uploaded.block()!!
        lateinit var file2: File
        file2.writeBytes(file.bytes)
        val bufferedReader: BufferedReader = file2.bufferedReader()
        return bufferedReader.use { it.readText() }
//        val inputStream: InputStream = File("example.txt").inputStream()
//        val inputString = inputStream.bufferedReader().use { it.readText() }
    }

    @PostMapping("1")
    fun task1(@RequestBody request: Task1Command): String {
        return task1Service.solve(request)
    }

}