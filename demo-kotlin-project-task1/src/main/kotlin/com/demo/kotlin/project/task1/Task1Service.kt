package com.demo.kotlin.project.task1

import com.demo.kotlin.project.domain.Task1Command
import org.springframework.stereotype.Component

@Component
class Task1Service {

    fun solve(command: Task1Command): String {
        return command.calories
    }

}