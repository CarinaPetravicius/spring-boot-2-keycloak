package com.example.demo.controller

import com.example.demo.api.ProductApi
import com.example.demo.model.MessageResponse
import com.example.demo.model.ProductHttpResponse
import com.example.demo.model.ProductRequest
import com.example.demo.model.ProductResponse
import com.example.demo.translator.ProductDomainToProductResponseTranslator
import com.example.demo.translator.ProductRequestToProductDomainTranslator
import com.example.demo.usecase.CreateProductUseCase
import com.example.demo.usecase.GetProductsForCompanyUseCase
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.data.domain.Page
import org.springframework.web.bind.annotation.RestController
import java.security.Principal
import java.util.*

@RestController
class ProductController(private val createProductUseCase: CreateProductUseCase,
                        private val getProductsForCompanyUseCase: GetProductsForCompanyUseCase) : ProductApi {

    private val log: Logger = LoggerFactory.getLogger(ProductController::class.java)

    override fun createProduct(principal: Principal, productRequest: ProductRequest): MessageResponse {
        log.info("Product API starting to creating the product: {}", productRequest.productName)

        val keycloakAuthentication = principal as KeycloakAuthenticationToken
        val token = keycloakAuthentication.account.keycloakSecurityContext.token

        log.info("Creating the product for user: {}", token.preferredUsername)

        val productDomain = ProductRequestToProductDomainTranslator().translate(productRequest,
                keycloakAuthentication.account.keycloakSecurityContext.realm, token.preferredUsername)

        createProductUseCase.execute(productDomain)

        return MessageResponse(ProductHttpResponse.PRODUCT_CREATED.httpStatus, ProductHttpResponse.PRODUCT_CREATED.httpMessage)
    }

    override fun getProduct(principal: Principal): String {
        log.info("Product API starting to get product")

        val keycloakAuthentication = principal as KeycloakAuthenticationToken
        val token = keycloakAuthentication.account.keycloakSecurityContext.token
        log.info("Username logged id: " + token.subject)
        log.info("Username logged name: " + token.preferredUsername)
        log.info("Realm instance: " + keycloakAuthentication.account.keycloakSecurityContext.realm)

        val uuidToken = UUID.fromString(token.subject)
        return "Return one product with success $uuidToken"
    }

    override fun getAllProducts(principal: Principal, page: Int, size: Int): Page<ProductResponse> {
        log.info("Product API starting to get all products for company")

        val keycloakAuthentication = principal as KeycloakAuthenticationToken
        val token = keycloakAuthentication.account.keycloakSecurityContext.token

        log.info("Getting all the products for user: {}", token.preferredUsername)

        val products = getProductsForCompanyUseCase.execute(page, size, keycloakAuthentication.account.keycloakSecurityContext.realm)

        return ProductDomainToProductResponseTranslator().translate(products)
    }

    override fun getMessageTest(): String {
        log.info("Product API starting to test public endpoint")
        return "Test success"
    }

}