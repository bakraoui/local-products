package com.localproducts.Controllers;

import com.localproducts.dto.categoryDto.CreateCategoryRequest;
import com.localproducts.service.Interfaces.ICategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final ICategoryService categoryService;

    public CategoryController(ICategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createAll(@RequestBody CreateCategoryRequest request){
        categoryService.save(request);
    }

}
