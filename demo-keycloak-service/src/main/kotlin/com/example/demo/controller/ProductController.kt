package com.example.demo.controller

import com.example.demo.api.ProductApi
import org.keycloak.KeycloakPrincipal
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.RestController
import java.security.Principal


@RestController
class ProductController : ProductApi {

    private val log: Logger = LoggerFactory.getLogger(ProductController::class.java)

    override fun getProduct(principal: Principal): String {
        log.info("Product API starting to get product")

        if (principal is KeycloakPrincipal<*>) {
            val token = principal.keycloakSecurityContext.token
            log.info(token.id)
            log.info(token.name)
        }

        return "Return one product with success"
    }

    override fun getAllProducts(principal: Principal): String {
        log.info("Product API starting to get all products for company")

        if (principal is KeycloakPrincipal<*>) {
            val token = principal.keycloakSecurityContext.token
            log.info(token.id)
            log.info(token.name)
        }

        return "Return all products of company with success"
    }

    override fun getMessageTest(): String {
        log.info("Product API starting to test public endpoint")
        return "Test success"
    }

}