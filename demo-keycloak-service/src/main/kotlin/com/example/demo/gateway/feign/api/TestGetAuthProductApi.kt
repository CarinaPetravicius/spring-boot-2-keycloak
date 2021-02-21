package com.example.demo.gateway.feign.api

import com.example.demo.gateway.feign.config.ProductGatewayConfig
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestHeader

@FeignClient(name = "getAuthProduct", url = "http://localhost:8090", configuration = [ProductGatewayConfig::class])
interface TestGetAuthProductApi {

    @GetMapping(value = ["/v1/product"],
            consumes = [MediaType.APPLICATION_JSON_VALUE],
            produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getAuthProduct(@RequestHeader authorization: String): String

}