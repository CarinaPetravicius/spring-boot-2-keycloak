package com.example.demo.controller

import com.example.demo.api.ProductApi
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.RestController
import java.security.Principal

@RestController
class ProductController : ProductApi {

    private val log: Logger = LoggerFactory.getLogger(ProductController::class.java)

    override fun getProduct(principal: Principal): String {
        log.info("Product API starting to get product")

        val keycloakAuthentication = principal as KeycloakAuthenticationToken
        val token = keycloakAuthentication.account.keycloakSecurityContext.token
        log.info("Username logged: " + token.preferredUsername)
        log.info("Realm instance: " + keycloakAuthentication.account.keycloakSecurityContext.realm)

        return "Return one product with success"
    }

    override fun getAllProducts(principal: Principal): String {
        log.info("Product API starting to get all products for company")

        val keycloakAuthentication = principal as KeycloakAuthenticationToken
        val token = keycloakAuthentication.account.keycloakSecurityContext.token
        log.info("Username logged: " + token.preferredUsername)
        log.info("Realm instance: " + keycloakAuthentication.account.keycloakSecurityContext.realm)

        return "Return all products of company with success"
    }

    override fun getMessageTest(): String {
        log.info("Product API starting to test public endpoint")
        return "Test success"
    }

}