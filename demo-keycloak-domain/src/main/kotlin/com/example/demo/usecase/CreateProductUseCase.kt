package com.example.demo.usecase

import com.example.demo.domain.ProductDomain
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import javax.inject.Named

@Named
class CreateProductUseCase() {

    private val log: Logger = LoggerFactory.getLogger(CreateProductUseCase::class.java)

    fun execute(productDomain: ProductDomain) {
        //if (hasProductCreatedGateway.execute(productDomain)) {
        //log.info("Product already exist")
        //throw ProductAlreadyExistException("Product already exist")
        //}

        //createProductGateway.execute(productDomain)
    }

}