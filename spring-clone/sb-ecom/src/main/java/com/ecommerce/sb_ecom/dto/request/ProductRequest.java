package com.ecommerce.sb_ecom.dto.request;

import com.ecommerce.sb_ecom.entity.ProductEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequest {
    private Long productId;
    private String productName;
    private String image;
    private String description;
    private Integer quantity;
    private double price;
    private double discount;


    public static ProductEntity toEntity(ProductRequest productRequest){
        ProductEntity productEntity = new ProductEntity();
        productEntity.setProductId(productRequest.getProductId());
        productEntity.setProductName(productRequest.getProductName());
        productEntity.setImage(productRequest.getImage());
        productEntity.setDescription(productRequest.getDescription());
        productEntity.setQuantity(productRequest.getQuantity());
        productEntity.setPrice(productRequest.getPrice());
        productEntity.setDiscount(productRequest.getDiscount());
        productEntity.setSpecialPrice(calculateSpecialPrice(productRequest.getPrice(), productRequest.getDiscount()));
        return productEntity;
    }

    private static double calculateSpecialPrice(double price, double discount){
        return price - (price * discount / 100);
    }
}
