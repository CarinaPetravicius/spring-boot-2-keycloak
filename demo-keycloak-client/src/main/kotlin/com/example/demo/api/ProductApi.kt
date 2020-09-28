package com.example.demo.api

import io.swagger.annotations.Api
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import java.security.Principal
import javax.annotation.security.RolesAllowed

@RequestMapping("/v1")
@Api(tags = ["Product"])
interface ProductApi {

    @RolesAllowed("branch_office")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/product")
    fun getProduct(principal: Principal): String

    @RolesAllowed("company")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/products/all")
    fun getAllProducts(principal: Principal): String

    @RolesAllowed("branch_office")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/test")
    fun getMessageTest(): String

}