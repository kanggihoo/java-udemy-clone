package com.ecommerce.sb_ecom.repositories;

import com.ecommerce.sb_ecom.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepositoriy extends JpaRepository<CategoryEntity, Long> {
    CategoryEntity findByCategoryName(String categoryName);
}
