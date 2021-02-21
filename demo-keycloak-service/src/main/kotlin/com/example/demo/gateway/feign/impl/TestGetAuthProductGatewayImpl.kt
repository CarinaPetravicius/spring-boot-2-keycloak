package com.example.demo.gateway.feign.impl

import com.example.demo.gateway.TestGetAuthProductGateway
import com.example.demo.gateway.feign.api.TestGetAuthProductApi
import feign.FeignException
import org.springframework.stereotype.Component

@Component
class TestGetAuthProductGatewayImpl(private val testGetAuthProductApi: TestGetAuthProductApi) : TestGetAuthProductGateway {

    override fun execute(token: String): String {
        try {
            return testGetAuthProductApi.getAuthProduct("Bearer $token")
        } catch (ex: FeignException) {
            throw ex
        }
    }

}