package com.zuhlke.uk.poc.easynotesapp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class EasyNotesAppApplication

fun main(args: Array<String>) {
    runApplication<EasyNotesAppApplication>(*args)
}
