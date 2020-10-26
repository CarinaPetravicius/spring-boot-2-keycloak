package com.example.demo.gateway

import com.example.demo.domain.AuthUserDomain

interface AuthUserGateway {

    fun execute(authUserDomain: AuthUserDomain): String

}