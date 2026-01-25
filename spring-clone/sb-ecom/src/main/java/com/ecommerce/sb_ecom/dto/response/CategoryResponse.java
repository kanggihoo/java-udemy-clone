package com.ecommerce.sb_ecom.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.ecommerce.sb_ecom.entity.CategoryEntity;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class CategoryResponse {
    private Long categoryId;
    private String categoryName;

    public static CategoryResponse from(CategoryEntity category) {
        return new CategoryResponse(category.getCategoryId(), category.getCategoryName());
    }

}

/*

    // 서비스에서 호출할 종합 변환 메서드
    public static CategoryPageResponse from(Page<Category> categoryPage) {
        // 1단계 변환(Entity -> Item DTO)을 여기서 수행
        List<CategoryResponse> dtos = categoryPage.getContent().stream()
                .map(CategoryResponse::from) // 단 개별 항목 변환 메서드 호출
                .toList();
        // 2단계 변환(포장) 수행
        CategoryPageResponse response = new CategoryPageResponse();
        response.setContent(dtos);
        response.setPageNumber(categoryPage.getNumber());
        response.setTotalElements(categoryPage.getTotalElements());
        // ... 나머지 세팅
        return response;
    }
}

*/