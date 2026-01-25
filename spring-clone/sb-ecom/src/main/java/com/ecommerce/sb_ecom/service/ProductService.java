package com.ecommerce.sb_ecom.service;

import com.ecommerce.sb_ecom.dto.request.ProductRequest;
import com.ecommerce.sb_ecom.dto.response.ProductResponse;

public interface ProductService {

    ProductResponse addProduct(Long categoryId , ProductRequest productRequest);

}
