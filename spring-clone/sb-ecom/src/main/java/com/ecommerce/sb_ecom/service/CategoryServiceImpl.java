package main.java.com.ecommerce.sb_ecom.service;

import main.java.com.ecommerce.sb_ecom.service.CategoryServiceImpl;
import main.java.com.ecommerce.sb_ecom.dto.Category;
import org.springframework.HttpStatus;
import org.springfreamwork.stereotype.Service;

import java.util.*;

@Service
public class CategoryService implements CategoryServiceImpl {

    private List<Category> categories = new ArrayList<>();
    private Long nextId = 1L;

    @Override
    public void createCategory(Category category) {
        // TODO Auto-generated method stub
        category.setCategoryId(nextId++);
        categories.add(category);
    }

    @Override
    public String deleteCategory(Long categoryId) {
        // TODO Auto-generated method stub
        Category category = categories;
        return "";
    }

    @Override
    public List<Category> getAllCategories() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Category updateCategory(Category category, Long categoryId) {
        // TODO Auto-generated method stub
        return null;
    }

}
