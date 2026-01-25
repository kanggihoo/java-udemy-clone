package com.ecommerce.sb_ecom.dto.request;

import com.ecommerce.sb_ecom.config.AppConstants;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
public class CategoryPageRequest {
    @Min(0)
    private Integer pageNumber = Integer.parseInt(AppConstants.PAGE_NUMBER);

    @Min(1) @Max(100)
    private Integer pageSize = Integer.parseInt(AppConstants.PAGE_SIZE);

    private String sortBy = AppConstants.SORT_CATEGORIES_BY;
    private String sortOrder = AppConstants.SORT_DIR;

}