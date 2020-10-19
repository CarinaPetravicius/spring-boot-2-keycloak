package com.example.demo.gateway

import com.example.demo.domain.ProductDomain

interface GetProductsForCompanyGateway {

    fun execute(page: Int, size: Int, companyName: String): List<ProductDomain>

}