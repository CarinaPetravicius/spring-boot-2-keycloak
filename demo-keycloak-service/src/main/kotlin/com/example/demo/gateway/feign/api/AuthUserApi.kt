package com.example.demo.gateway.feign.api

import com.example.demo.gateway.feign.config.AuthGatewayConfig
import com.example.demo.gateway.feign.model.AuthResponse
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

@FeignClient(name = "authUserApi", url = "http://localhost:8080/auth", configuration = [AuthGatewayConfig::class])
interface AuthUserApi {

    @PostMapping(value = ["/realms/company_master/protocol/openid-connect/token"],
            consumes = [MediaType.APPLICATION_FORM_URLENCODED_VALUE],
            produces = [MediaType.APPLICATION_JSON_VALUE])
    fun authUser(@RequestBody form: Map<String?, *>?): AuthResponse

}