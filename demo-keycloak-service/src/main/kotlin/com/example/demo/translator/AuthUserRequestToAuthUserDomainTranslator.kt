package com.example.demo.translator

import com.example.demo.domain.AuthUserDomain
import com.example.demo.model.AuthUserRequest
import java.util.UUID

class AuthUserRequestToAuthUserDomainTranslator {

    // Values fixed for test
    fun translate(authUserRequest: AuthUserRequest): AuthUserDomain {
        return AuthUserDomain(username = authUserRequest.username, password = authUserRequest.password, clientId = "backend-api",
                clientSecret = UUID.fromString("1b5c82ed-00b2-4f37-852a-cbf3990fb372"))
    }

}