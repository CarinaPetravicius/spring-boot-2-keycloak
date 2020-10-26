package com.example.demo.gateway.feign.model

import com.fasterxml.jackson.annotation.JsonProperty

data class AuthResponse(

        @JsonProperty("access_token")
        val accessToken: String,

        @JsonProperty("token_type")
        val tokenType: String

)