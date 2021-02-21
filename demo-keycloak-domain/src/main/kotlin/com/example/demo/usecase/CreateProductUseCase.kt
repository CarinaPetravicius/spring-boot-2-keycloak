package com.example.demo.usecase

import com.example.demo.domain.ProductDomain
import com.example.demo.exception.ProductAlreadyExistException
import com.example.demo.gateway.CreateProductGateway
import com.example.demo.gateway.HasProductCreatedGateway
import com.example.demo.gateway.TestGetAuthProductGateway
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import javax.inject.Named

@Named
class CreateProductUseCase(private val hasProductCreatedGateway: HasProductCreatedGateway,
                           private val createProductGateway: CreateProductGateway,
                           private val testGetAuthProductGateway: TestGetAuthProductGateway) {

    private val log: Logger = LoggerFactory.getLogger(CreateProductUseCase::class.java)

    fun execute(productDomain: ProductDomain, token: String) {
        // test to call other endpoint with the same authentication.
        testGetAuthProduct(token)

        if (hasProductCreatedGateway.execute(productDomain)) {
            log.info("Product already exist")
            throw ProductAlreadyExistException("Product already exist")
        }

        createProductGateway.execute(productDomain)
    }

    private fun testGetAuthProduct(token: String) {
        val product = testGetAuthProductGateway.execute(token)
        log.info("The authenticated product {}", product)
    }

}