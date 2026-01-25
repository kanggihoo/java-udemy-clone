package com.ecommerce.sb_ecom.service;

import org.springframework.stereotype.Service;

import com.ecommerce.sb_ecom.dto.request.ProductRequest;
import com.ecommerce.sb_ecom.dto.response.ProductResponse;
import com.ecommerce.sb_ecom.repositories.CategoryRepository;
import com.ecommerce.sb_ecom.repositories.ProductRepository;
import com.ecommerce.sb_ecom.entity.CategoryEntity;
import com.ecommerce.sb_ecom.entity.ProductEntity;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    public ProductServiceImpl(CategoryRepository categoryRepository, ProductRepository productRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    @Override
    public ProductResponse addProduct(Long categoryId, ProductRequest productRequest) {
        CategoryEntity category = categoryRepository.findById(categoryId)
            .orElseThrow(() -> new RuntimeException("Category not found"));

        List<ProductEntity> products =category.getProducts();

        boolean isProductNotPresent = true;
        for(ProductEntity product : products){
            if(product.getProductName().equals(productRequest.getProductName())){
                isProductNotPresent = false;
                break;
            }
        }

        if(isProductNotPresent){
            ProductEntity productEntity = ProductRequest.toEntity(productRequest);
            productEntity.setImage("default.png");
            ProductEntity savedProduct = productRepository.save(productEntity);
            return ProductResponse.from(savedProduct);


        }else{
            throw new RuntimeException("Product already exists");
        }

    }

    

}
