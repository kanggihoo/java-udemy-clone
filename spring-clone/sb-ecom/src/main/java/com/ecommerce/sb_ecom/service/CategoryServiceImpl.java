package com.ecommerce.sb_ecom.service;

import com.ecommerce.sb_ecom.dto.request.CategoryPageRequest;
import com.ecommerce.sb_ecom.dto.request.CategoryRequest;
import com.ecommerce.sb_ecom.dto.response.CategoryResponse;
import com.ecommerce.sb_ecom.dto.response.CategoryPageResponse;
import com.ecommerce.sb_ecom.entity.CategoryEntity;
import com.ecommerce.sb_ecom.repositories.CategoryRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    public CategoryPageResponse getAllCategories(CategoryPageRequest categoryPageRequest) {
        Integer pageNumber = categoryPageRequest.getPageNumber();
        Integer pageSize = categoryPageRequest.getPageSize();
        String sortBy = categoryPageRequest.getSortBy();
        String sortOrder = categoryPageRequest.getSortOrder();

        Sort sortByAndOrder = sortOrder.equalsIgnoreCase("asc") 
                ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();
    
        Pageable pageDetails = PageRequest.of(pageNumber, pageSize, sortByAndOrder);

        Page<CategoryEntity> categoryEntities = categoryRepository.findAll(pageDetails);
        List<CategoryEntity> categories = categoryEntities.getContent();

        if(categories.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found");
        }

        List<CategoryResponse> categoryResponses = categories.stream()
            .map(CategoryResponse::from)
            .toList();

        CategoryPageResponse categoryPageResponse = new CategoryPageResponse();
        categoryPageResponse.setContent(categoryResponses);
        categoryPageResponse.setPageNumber(categoryEntities.getNumber());
        categoryPageResponse.setPageSize(categoryEntities.getSize());
        categoryPageResponse.setTotalElements(categoryEntities.getTotalElements());
        categoryPageResponse.setTotalpages(categoryEntities.getTotalPages());
        categoryPageResponse.setLastPage(categoryEntities.isLast());
        return categoryPageResponse;
    }

    @Override
    public CategoryResponse createCategory(CategoryRequest categoryRequest) {
        CategoryEntity categoryEntity = CategoryRequest.toEntity(categoryRequest);
        categoryRepository.save(categoryEntity);
        return CategoryResponse.from(categoryEntity);
    }

    @Override
    public CategoryResponse deleteCategory(Long categoryId) {
        CategoryEntity categoryEntity = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found"));

        categoryRepository.delete(categoryEntity);
        return CategoryResponse.from(categoryEntity);
    }

    @Override
    public CategoryResponse updateCategory(CategoryResponse category, Long categoryId) {
        CategoryEntity existingCategory = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found"));

        existingCategory.setCategoryName(category.getCategoryName());
        CategoryEntity savedCategory = categoryRepository.save(existingCategory);

        // return new CategoryResponse(savedCategory.getCategoryId(), savedCategory.getCategoryName());
        return CategoryResponse.from(savedCategory);
    }
}
