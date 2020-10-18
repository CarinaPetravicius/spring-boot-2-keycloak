package com.example.demo.gateway

import com.example.demo.domain.ProductDomain

interface CreateProductGateway {

    fun execute(productDomain: ProductDomain)

}