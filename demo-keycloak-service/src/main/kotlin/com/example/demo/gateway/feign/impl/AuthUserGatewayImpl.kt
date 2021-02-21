package com.example.demo.gateway.feign.impl

import com.example.demo.domain.AuthUserDomain
import com.example.demo.gateway.AuthUserGateway
import com.example.demo.gateway.feign.api.AuthUserApi
import feign.FeignException
import org.springframework.stereotype.Component

@Component
class AuthUserGatewayImpl(private val authUserApi: AuthUserApi) : AuthUserGateway {

    override fun execute(authUserDomain: AuthUserDomain): String {
        try {
            val form: Map<String?, *> = mapOf("username" to authUserDomain.username, "password" to authUserDomain.password,
                    "grant_type" to authUserDomain.grantType, "client_id" to authUserDomain.clientId,
                    "client_secret" to authUserDomain.clientSecret)

            val authResponse = authUserApi.authUser(form)
            return authResponse.accessToken
        } catch (ex: FeignException) {
            throw ex
        }
    }

}