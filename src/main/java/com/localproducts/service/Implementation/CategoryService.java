package com.localproducts.service.Implementation;

import com.localproducts.dto.categoryDto.CreateCategoryRequest;
import com.localproducts.entities.Category;
import com.localproducts.exceptions.RecordExistException;
import com.localproducts.exceptions.RecordNotExistException;
import com.localproducts.exceptions.RecordNotValidException;
import com.localproducts.helpers.categoryHelpers.CategoryValidatorResult;
import com.localproducts.mappers.CategoryMapper;
import com.localproducts.repositories.CategoryRepository;
import com.localproducts.service.Interfaces.ICategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.localproducts.helpers.categoryHelpers.CategoryValidatorResult.SUCCESS;
import static com.localproducts.helpers.categoryHelpers.CreateCategoryRequestHandler.isLabelValid;

@Service
public class CategoryService implements ICategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void save(CreateCategoryRequest request){
        validateCategoryRequest(request);

        checkByLabelIfCategoryExist(request.getLabel());

        Category category = CategoryMapper.categoryRequestToCategory(request);

        categoryRepository.save(category);
    }


    @Override
    public Category getCategory(Long id){
        return categoryRepository.findById(id).orElseThrow(() -> new RecordNotExistException("No category with that Id"));
    }

    @Override
    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }

    @Override
    public Category getByName(String label) {
        return categoryRepository.findByLabel(label)
                .stream().findFirst()
                .orElseThrow(() -> new RecordNotExistException("Category with given name not Found"));
    }

    @Override
    public void deleteById(Long id) {
        checkByIdIfCategoryNotExist(id);
        categoryRepository.deleteById(id);
    }

    @Override
    public void updateCategory(Category category){
        Optional<Category> categoryOptional = categoryRepository.findByLabel(category.getLabel());
        if (categoryOptional.isPresent())
            throw new RecordExistException("name of this category already exist");

        categoryRepository.save(category);
    }


    private void validateCategoryRequest(CreateCategoryRequest request) {
        CategoryValidatorResult result = isLabelValid()
                .apply(request);
        if (!result.equals(SUCCESS)){
            throw new RecordNotValidException(result.getMessage());
        }
    }

    private void checkByLabelIfCategoryExist(String label) {
        Optional<Category> categoryOptional = categoryRepository.findByLabel(label);
        if (categoryOptional.isPresent()) {
            throw new RecordExistException("category already exist");
        }
    }

    private void checkByIdIfCategoryNotExist(Long id) {
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        if (categoryOptional.isEmpty()) {
            throw new RecordExistException("Category Not Found with given Id.");
        }
    }

}
