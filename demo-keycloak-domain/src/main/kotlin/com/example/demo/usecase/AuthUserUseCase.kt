package com.example.demo.usecase

import com.example.demo.domain.AuthUserDomain
import com.example.demo.gateway.AuthUserGateway
import javax.inject.Named

@Named
class AuthUserUseCase(private val authUserGateway: AuthUserGateway) {

    fun execute(authUserDomain: AuthUserDomain): String {
        return authUserGateway.execute(authUserDomain)
    }

}