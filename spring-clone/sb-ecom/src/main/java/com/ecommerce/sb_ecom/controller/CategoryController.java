package com.ecommerce.sb_ecom.controller;

import com.ecommerce.sb_ecom.service.CategoryService;
import com.ecommerce.sb_ecom.dto.request.CategoryPageRequest;
import com.ecommerce.sb_ecom.dto.request.CategoryRequest;
import com.ecommerce.sb_ecom.dto.response.CategoryPageResponse;
import com.ecommerce.sb_ecom.dto.response.CategoryResponse;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api")
public class CategoryController {
    
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @GetMapping("/public/categories")
    public ResponseEntity<CategoryPageResponse> getAllCategories(@Valid CategoryPageRequest categoryPageRequest) {
        CategoryPageResponse categoryPageResponse = categoryService.getAllCategories(categoryPageRequest);
        return new ResponseEntity<>(categoryPageResponse, HttpStatus.OK);
    }

    @PostMapping("/public/categories")
    // @RequestMapping(value = "/public/categories", method = RequestMethod.POST)
    public ResponseEntity<CategoryResponse> createCategory(@Valid @RequestBody CategoryRequest categoryRequest) {
        CategoryResponse categoryResponse = categoryService.createCategory(categoryRequest);
        return new ResponseEntity<>(categoryResponse, HttpStatus.CREATED);
    }

    @DeleteMapping("/admin/categories/{categoryId}")
    public ResponseEntity<CategoryResponse> deleteCategory(@PathVariable Long categoryId) {
        CategoryResponse categoryResponse = categoryService.deleteCategory(categoryId);
        return new ResponseEntity<>(categoryResponse, HttpStatus.OK);
        
    }

    @PutMapping("/public/categories/{categoryId}")
    public ResponseEntity<CategoryResponse> updateCategory(
            @Valid @RequestBody CategoryResponse category,
            @PathVariable Long categoryId
        ) {
            CategoryResponse updatedCategory = categoryService.updateCategory(category, categoryId);
            return new ResponseEntity<>(updatedCategory, HttpStatus.OK);
        }       

}
