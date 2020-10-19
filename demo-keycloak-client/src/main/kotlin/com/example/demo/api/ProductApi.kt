package com.example.demo.api

import com.example.demo.model.MessageResponse
import com.example.demo.model.ProductRequest
import com.example.demo.model.ProductResponse
import io.swagger.annotations.*
import org.springframework.data.domain.Page
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.security.Principal
import javax.validation.Valid

@RequestMapping("/v1")
@Api(tags = ["Product"])
interface ProductApi {

    @ApiOperation(value = "Create a product", notes = "Create a product")
    @ApiResponses(value = [ApiResponse(code = 201, message = "Created", response = MessageResponse::class),
        ApiResponse(code = 208, message = "Product already exist", response = MessageResponse::class),
        ApiResponse(code = 400, message = "Bad request", response = MessageResponse::class),
        ApiResponse(code = 500, message = "Internal error to create the product", response = MessageResponse::class)])
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/product")
    fun createProduct(principal: Principal, @Valid @RequestBody productRequest: ProductRequest): MessageResponse

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/product")
    fun getProduct(principal: Principal): String

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/products/all")
    fun getAllProducts(principal: Principal, @ApiParam(value = "page number.") @RequestParam(value = "page") page: Int,
                       @ApiParam(value = "quantity of items per page.") @RequestParam(value = "size") size: Int): Page<ProductResponse>

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/test")
    fun getMessageTest(): String

}