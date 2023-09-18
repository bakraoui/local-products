package com.localproducts.Controllers;

import com.localproducts.dto.productDto.CreateProductRequest;
import com.localproducts.dto.productDto.ProductResponse;
import com.localproducts.service.Interfaces.IProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody CreateProductRequest request){
          productService.save(request);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAll(){
       return productService.getAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProductResponse getById(@PathVariable Long id){
        return  productService.getById(id);
    }

    @GetMapping("/cooperative/{cooperativeId}")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getByCooperative(@PathVariable Long cooperativeId){
        return productService.getByCooperative(cooperativeId);
    }

    @GetMapping("/category/{categoryId}")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getByCategory(@PathVariable Long categoryId){
        return productService.getByCategory(categoryId);
    }



    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@PathVariable Long id){
        productService.deleteById(id);
    }
}
