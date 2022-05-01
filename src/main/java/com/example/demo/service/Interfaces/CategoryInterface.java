package com.example.demo.service.Interfaces;

import com.example.demo.entities.Category;

import java.util.List;

public interface CategoryInterface {


    public void addCategory(Category category);
    public void addCategories(Category...category);
    public  Category getCategory(Long id);

    List<Category> getAllCategories();

    public Category getByName(String name);
    public void deleteCategory(Category category);

    void deleteById(Long id);

    void updateCategory(Category category);
}
