package com.example.demo.gateway.feign.config

import feign.Logger
import feign.Request
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean

open class BaseFeignConfig {

    @Value("\${feign.gateway.connectTimeout:2000}")
    private val connectTimeout = 0

    @Value("\${feign.gateway.readTimeout:2000}")
    private val readTimeout = 0

    @Bean
    fun feignLoggerLevel(): Logger.Level? {
        return Logger.Level.FULL
    }

    @Bean
    fun options(): Request.Options? {
        return Request.Options(connectTimeout, readTimeout)
    }

}