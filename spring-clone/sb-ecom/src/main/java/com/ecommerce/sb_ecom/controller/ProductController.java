package com.ecommerce.sb_ecom.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.sb_ecom.dto.request.ProductRequest;
import com.ecommerce.sb_ecom.dto.response.ProductResponse;
import com.ecommerce.sb_ecom.service.ProductService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/api")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;

    }

    @PostMapping("/admin/categories/{categoryId}/product") // Adds a new product to a category
    //TODO : 요청 데이터 유효성 검증 로직 추가 
    public ResponseEntity<ProductResponse> addProduct(
        @PathVariable Long categoryId,
        @Valid @RequestBody ProductRequest productRequest 
    ) {
        ProductResponse savedProduct = productService.addProduct(categoryId, productRequest);
        
        return new ResponseEntity<>(savedProduct , HttpStatus.CREATED);
    }
    

    @GetMapping("/public/products")
    public String getMethodName() {
        return "Hello World";
    }
    




}
