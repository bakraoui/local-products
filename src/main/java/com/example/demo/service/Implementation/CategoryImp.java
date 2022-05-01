package com.example.demo.service.Implementation;

import com.example.demo.entities.Category;
import com.example.demo.repositories.CategoryRepository;
import com.example.demo.service.Interfaces.CategoryInterface;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@NoArgsConstructor
@AllArgsConstructor
@Service
public class CategoryImp implements CategoryInterface {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public void addCategory(Category category){
        Optional<Category> categoryOptional = categoryRepository.findByLabel(category.getLabel());
        if (categoryOptional.isPresent()) throw new IllegalStateException("category already exist");
        else categoryRepository.save(category);
    }
    @Override
    public void addCategories(Category ...categories){
        int i =0;
        for (Category category : categories ) {
            String label = category.getLabel();
            Optional<Category> cat = categoryRepository.findByLabel(label);
            if (!cat.isPresent()) categoryRepository.save(category);
            else i++;
        }
        if (i != 0 ) throw new IllegalStateException("some categories already exist");
    }

    @Override
    public Category getCategory(Long id){
        return categoryRepository.getById(id);
    }

    @Override
    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }

    @Override
    public Category getByName(String name) {
        return categoryRepository.findByLabel(name)
                .stream().findFirst().orElse(null);
    }

    @Override
    public void deleteCategory(Category category) {
        categoryRepository.delete(category);
    }

    @Override
    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public void updateCategory(Category category){
        Optional<Category> categoryOptional = categoryRepository.findByLabel(category.getLabel());
        if (categoryOptional.isPresent())
            throw new IllegalStateException("name of this category already exist");
        else categoryRepository.save(category);
    }
}
