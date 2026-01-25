package com.ecommerce.sb_ecom.service;


import com.ecommerce.sb_ecom.dto.request.CategoryPageRequest;
import com.ecommerce.sb_ecom.dto.request.CategoryRequest;
import com.ecommerce.sb_ecom.dto.response.CategoryPageResponse;
import com.ecommerce.sb_ecom.dto.response.CategoryResponse;

public interface CategoryService {
    CategoryPageResponse getAllCategories(CategoryPageRequest categoryPageRequest);

    CategoryResponse createCategory(CategoryRequest category);

    CategoryResponse deleteCategory(Long categoryId);

    CategoryResponse updateCategory(CategoryResponse category, Long categoryId);

}
