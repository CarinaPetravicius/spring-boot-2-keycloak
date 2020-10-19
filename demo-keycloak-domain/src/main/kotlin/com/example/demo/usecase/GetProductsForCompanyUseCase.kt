package com.example.demo.usecase

import com.example.demo.domain.ProductDomain
import com.example.demo.gateway.GetProductsForCompanyGateway
import javax.inject.Named

@Named
class GetProductsForCompanyUseCase(private val getProductsForCompanyGateway: GetProductsForCompanyGateway) {

    fun execute(page: Int, size: Int, companyName: String): List<ProductDomain> {
        return getProductsForCompanyGateway.execute(page, size, companyName)
    }

}