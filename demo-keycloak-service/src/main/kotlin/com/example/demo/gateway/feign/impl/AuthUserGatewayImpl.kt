package com.example.demo.gateway.feign.impl

import com.example.demo.domain.AuthUserDomain
import com.example.demo.gateway.AuthUserGateway
import com.example.demo.gateway.feign.api.AuthUserApi
import org.springframework.stereotype.Component

@Component
class AuthUserGatewayImpl(private val authUserApi: AuthUserApi) : AuthUserGateway {

    override fun execute(authUserDomain: AuthUserDomain): String {
        val authResponse = authUserApi.authUser(authUserDomain)

        return authResponse.accessToken
    }

}