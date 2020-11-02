package com.example.demo.domain

data class AuthUserDomain(
        val username: String,
        val password: String,
        val grantType: String = "password",
        val clientId: String,
        val clientSecret: String
)