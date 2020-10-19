package com.example.demo.translator

import com.example.demo.domain.ProductDomain
import com.example.demo.model.ProductResponse
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import java.util.stream.Collectors

class ProductDomainToProductResponseTranslator {

    fun translate(productDomain: List<ProductDomain>): Page<ProductResponse> {
        val productsResponse = productDomain.stream().map(::translateToProductResponse).collect(Collectors.toList())
        return PageImpl(productsResponse)
    }

    private fun translateToProductResponse(productDomain: ProductDomain): ProductResponse {
        return ProductResponse(productDomain.productName, productDomain.unitType, productDomain.createdDate)
    }

}