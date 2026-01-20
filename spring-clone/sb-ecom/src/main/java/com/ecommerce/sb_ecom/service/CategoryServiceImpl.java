package com.ecommerce.sb_ecom.service;

import com.ecommerce.sb_ecom.dto.Category;
import com.ecommerce.sb_ecom.entity.CategoryEntity;
import com.ecommerce.sb_ecom.repositories.CategoryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> getAllCategories() {
        List<CategoryEntity> categoryEntities = categoryRepository.findAll();
        return categoryEntities.stream()
                .map(entity -> new Category(entity.getCategoryId(), entity.getCategoryName()))
                .collect(Collectors.toList());
    }

    @Override
    public void createCategory(Category category) {
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setCategoryName(category.getCategoryName());
        categoryRepository.save(categoryEntity);
    }

    @Override
    public String deleteCategory(Long categoryId) {
        CategoryEntity categoryEntity = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found"));

        categoryRepository.delete(categoryEntity);
        return "categoryId: " + categoryId + " deleted successfully !!";
    }

    @Override
    public Category updateCategory(Category category, Long categoryId) {
        CategoryEntity existingCategory = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found"));

        existingCategory.setCategoryName(category.getCategoryName());
        CategoryEntity savedCategory = categoryRepository.save(existingCategory);

        return new Category(savedCategory.getCategoryId(), savedCategory.getCategoryName());
    }
}
