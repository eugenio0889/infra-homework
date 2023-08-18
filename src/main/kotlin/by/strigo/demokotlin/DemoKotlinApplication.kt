package by.strigo.demokotlin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class DemoKotlinApplication

fun main(vararg args: String) {
    runApplication<DemoKotlinApplication>(*args)
}


@RestController
class MessageController {

    val message = "Hello World"

    @GetMapping("/")
    fun index() = message
}
