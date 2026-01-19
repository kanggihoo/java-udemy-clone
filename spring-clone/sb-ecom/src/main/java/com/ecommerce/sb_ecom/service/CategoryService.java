package main.java.com.ecommerce.sb_ecom.service;

import main.java.com.ecommerce.sb_ecom.dto.Category;
import java.util.*;

public interface CategoryServiceImpl {
    List<Category> getAllCategories();

    void createCategory(Category category);

    String deleteCategory(Long categoryId);

    Category updateCategory(Category category, Long categoryId);

}
