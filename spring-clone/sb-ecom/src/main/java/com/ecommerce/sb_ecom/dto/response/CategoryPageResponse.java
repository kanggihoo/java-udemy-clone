package com.ecommerce.sb_ecom.dto.response;

import java.util.List;

// import com.ecommerce.sb_ecom.dto.response.CategoryResponse;
import com.ecommerce.sb_ecom.entity.CategoryEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryPageResponse {
    private List<CategoryResponse> content;
    private Integer pageNumber;
    private Integer pageSize;
    private Long totalElements;
    private Integer totalpages;
    private boolean lastPage;

    

    public static CategoryResponse from(CategoryEntity categoryEntity) {
        return new CategoryResponse(categoryEntity.getCategoryId(), categoryEntity.getCategoryName());
    }

}
