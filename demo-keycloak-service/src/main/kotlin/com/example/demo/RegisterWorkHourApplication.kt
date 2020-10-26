package com.example.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableFeignClients(basePackages = ["com.example.demo"])
class RegisterWorkHourApplication

fun main(args: Array<String>) {
	runApplication<RegisterWorkHourApplication>(*args)
}
