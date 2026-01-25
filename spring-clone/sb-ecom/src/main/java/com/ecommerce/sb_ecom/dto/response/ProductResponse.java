package com.ecommerce.sb_ecom.dto.response;

import com.ecommerce.sb_ecom.entity.ProductEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponse {

    private Long productId;
    private String productName;
    private String image;
    private String description;
    private Integer quantity;
    private double price;
    private double discount;
    private double specialPrice;

    public static ProductResponse from(ProductEntity productEntity){
        ProductResponse productResponse = new ProductResponse();
        productResponse.setProductId(productEntity.getProductId());
        productResponse.setProductName(productEntity.getProductName());
        productResponse.setImage(productEntity.getImage());
        productResponse.setDescription(productEntity.getDescription());
        productResponse.setQuantity(productEntity.getQuantity());
        productResponse.setPrice(productEntity.getPrice());
        productResponse.setDiscount(productEntity.getDiscount());
        productResponse.setSpecialPrice(productEntity.getSpecialPrice());
        return productResponse;
    }
}
