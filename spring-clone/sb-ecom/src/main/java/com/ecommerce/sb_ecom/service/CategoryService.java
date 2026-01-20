package com.ecommerce.sb_ecom.service;

import com.ecommerce.sb_ecom.dto.Category;
import java.util.*;

public interface CategoryService {
    List<Category> getAllCategories();

    void createCategory(Category category);

    String deleteCategory(Long categoryId);

    Category updateCategory(Category category, Long categoryId);

}
