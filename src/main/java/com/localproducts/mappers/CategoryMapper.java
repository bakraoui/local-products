package com.localproducts.mappers;

import com.localproducts.dto.categoryDto.CategoryResponse;
import com.localproducts.dto.categoryDto.CreateCategoryRequest;
import com.localproducts.entities.Category;

public class CategoryMapper {

    public static Category categoryRequestToCategory(CreateCategoryRequest request) {
        return Category.builder()
                .label(request.getLabel())
                .build();
    }

    public static CategoryResponse categoryToCategoryResponse(Category category) {
        return CategoryResponse.builder()
                .id(category.getId())
                .label(category.getLabel())
                .build();
    }
}
