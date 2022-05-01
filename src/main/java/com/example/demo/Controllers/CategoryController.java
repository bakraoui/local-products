package com.example.demo.Controllers;

import com.example.demo.entities.Category;
import com.example.demo.entities.Produit;
import com.example.demo.service.Implementation.CategoryImp;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@NoArgsConstructor
@AllArgsConstructor
@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    @Autowired
    CategoryImp categoryImp;

    @PostMapping("")
    public String create(@RequestBody Category...categories){
        try {
            categoryImp.addCategories(categories);
            return "success...";
        }catch (Exception e){
            return e.getMessage();
        }

    }

}
