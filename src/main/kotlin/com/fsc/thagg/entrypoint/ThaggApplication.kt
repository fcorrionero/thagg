package com.fsc.thagg.entrypoint

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ThaggApplication

fun main(args: Array<String>) {
    runApplication<ThaggApplication>(*args)
}
