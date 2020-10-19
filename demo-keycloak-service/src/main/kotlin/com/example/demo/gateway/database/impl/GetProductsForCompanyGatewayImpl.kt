package com.example.demo.gateway.database.impl

import com.example.demo.domain.ProductDomain
import com.example.demo.gateway.GetProductsForCompanyGateway
import com.example.demo.gateway.database.model.ProductDB
import com.example.demo.gateway.database.repository.ProductRepository
import com.example.demo.gateway.database.translator.ProductDBToProductDomainTranslator
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import java.util.stream.Collectors
import javax.inject.Named

@Named
class GetProductsForCompanyGatewayImpl(private val productRepository: ProductRepository) : GetProductsForCompanyGateway {

    override fun execute(page: Int, size: Int, companyName: String): List<ProductDomain> {
        val proposalsDb: Page<ProductDB> = productRepository.findByCompanyNameAndActive(PageRequest.of(page, size), companyName, true)

        return proposalsDb.stream().map(ProductDBToProductDomainTranslator()::translate).collect(Collectors.toList())
    }

}