package com.test.test_spring

import com.test.test_spring.domain.Person
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
@RestController
class TestSpringApplication {

	@GetMapping
	fun hi(): Person {
		return Person(name = "Park", lastName = "Sangyeong", age = 5)
	}
}

fun main(args: Array<String>) {
	runApplication<TestSpringApplication>(*args)
}
