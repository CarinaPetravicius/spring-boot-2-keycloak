package com.example.demo.domain

import java.util.UUID

data class AuthUserDomain(
        val username: String,
        val password: String,
        val grantType: String = "password",
        val clientId: String,
        val clientSecret: UUID
)