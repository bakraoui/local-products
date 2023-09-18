package com.localproducts.service.Interfaces;

import com.localproducts.dto.categoryDto.CreateCategoryRequest;
import com.localproducts.entities.Category;

import java.util.List;

public interface ICategoryService {


    public void save(CreateCategoryRequest request);
    public Category getCategory(Long id);

    List<Category> getAllCategories();

    public Category getByName(String name);

    void deleteById(Long id);

    void updateCategory(Category category);
}
