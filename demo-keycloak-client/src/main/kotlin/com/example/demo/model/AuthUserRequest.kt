package com.example.demo.model

import io.swagger.annotations.ApiModelProperty
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

data class AuthUserRequest(
        @ApiModelProperty(required = true)
        @field:NotBlank(message = "The username must be informed")
        @field:Size(min = 2, max = 200, message = "The min username size is 2 and the max is 50")
        val username: String,

        @ApiModelProperty(required = true)
        @field:NotBlank(message = "The password must be informed")
        @field:Size(min = 4, max = 200, message = "The min password size is 4 and the max is 50")
        val password: String
)