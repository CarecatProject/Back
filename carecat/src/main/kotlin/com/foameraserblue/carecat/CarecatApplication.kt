package com.foameraserblue.carecat

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.context.annotation.EnableAspectJAutoProxy
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@SpringBootApplication
@EnableAspectJAutoProxy
@EnableJpaAuditing
class CarecatApplication

fun main(args: Array<String>) {
	runApplication<CarecatApplication>(*args)
}
