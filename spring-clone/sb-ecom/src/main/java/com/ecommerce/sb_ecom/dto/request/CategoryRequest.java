package com.ecommerce.sb_ecom.dto.request;

import com.ecommerce.sb_ecom.entity.CategoryEntity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryRequest {
    
    // private Long categoryId;
    @NotBlank
    @Size(min = 5, message = "Category name must contain atleast 5 characters")
    private String categoryName;


    public static CategoryEntity toEntity(CategoryRequest categoryRequest){
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setCategoryName(categoryRequest.getCategoryName());
        return categoryEntity;
    }

}
