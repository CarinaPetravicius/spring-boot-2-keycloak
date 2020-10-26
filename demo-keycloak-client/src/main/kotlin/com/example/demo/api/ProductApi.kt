package com.example.demo.api

import com.example.demo.model.AuthUserRequest
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

    @ApiOperation(value = "Get all the products", notes = "Get all the products of a company")
    @ApiResponses(value = [ApiResponse(code = 200, message = "Success", response = ProductResponse::class),
        ApiResponse(code = 400, message = "Bad request", response = MessageResponse::class),
        ApiResponse(code = 500, message = "Internal error to all products", response = MessageResponse::class)])
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/products/all")
    fun getAllProducts(principal: Principal, @ApiParam(value = "page number.") @RequestParam(value = "page") page: Int,
                       @ApiParam(value = "quantity of items per page.") @RequestParam(value = "size") size: Int): Page<ProductResponse>

    @ApiOperation(value = "Get a message for test", notes = "Get a message for test")
    @ApiResponses(value = [ApiResponse(code = 200, message = "Success", response = String::class)])
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/test")
    fun getMessageTest(): String

    @ApiOperation(value = "Generate a Token", notes = "Generate a Token")
    @ApiResponses(value = [ApiResponse(code = 201, message = "Created", response = String::class),
        ApiResponse(code = 400, message = "Bad request", response = MessageResponse::class),
        ApiResponse(code = 500, message = "Internal error to generate the token", response = MessageResponse::class)])
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/token")
    fun generateToken(@Valid @RequestBody authUserRequest: AuthUserRequest): String

}