package com.ecommerce.sb_ecom.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.ecommerce.sb_ecom.entity.CategoryEntity;
import com.ecommerce.sb_ecom.repositories.CategoryRepositoriy;
import java.util.*;
import org.springframework.web.server.ResponseStatusException;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepositoriy categoryRepositoriy;

    public CategoryServiceImpl(CategoryRepositoriy categoryRepositoriy) {
        this.categoryRepositoriy = categoryRepositoriy;
    }

    @Override
    public void createCategory(CategoryEntity category) {

        category.setCategoryId(nextId++);
        categories.add(category);
    }

    @Override
    public String deleteCategory(Long categoryId) {

        CategoryRepositoriy category = categories.stream().filter(c -> c.getCategoryId().equals(categoryId)).findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource not found"));

        categories.remove(category);
        return "categoryId: " + categoryId + " deleted successfully !!";
    }

    @Override
    public List<CategoryRepositoriy> getAllCategories() {
        return this.categoryRepositoriy.findAll()
    }

    @Override
    public CategoryRepositoriy updateCategory(CategoryRepositoriy category, Long categoryId) {

        Optional<CategoryRepositoriy> optionalCategory = categories.stream()
                .filter(c -> c.getCategoryId().equals(categoryId))
                .findFirst();
        if (optionalCategory.isPresent()) {
            CategoryRepositoriy existingCategory = optionalCategory.get();
            existingCategory.setCategoryName(category.getCategoryName());
            return existingCategory;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found");
        }

    }

}
