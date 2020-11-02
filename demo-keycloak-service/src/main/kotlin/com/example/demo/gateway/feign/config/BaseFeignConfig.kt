package com.example.demo.gateway.feign.config

import feign.Logger
import feign.Request
import feign.codec.Encoder
import feign.form.spring.SpringFormEncoder
import org.springframework.beans.factory.ObjectFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.http.HttpMessageConverters
import org.springframework.cloud.openfeign.support.SpringEncoder
import org.springframework.context.annotation.Bean


open class BaseFeignConfig {

    @Autowired
    private val messageConverters: ObjectFactory<HttpMessageConverters>? = null

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

    @Bean
    open fun feignFormEncoder(): Encoder? {
        return SpringFormEncoder(SpringEncoder(messageConverters))
    }

}