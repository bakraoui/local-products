package com.localproducts.service.Interfaces;

import com.localproducts.dto.productDto.CreateProductRequest;
import com.localproducts.dto.productDto.ProductResponse;

import java.util.List;

public  interface IProductService {

    void save(CreateProductRequest request);
    ProductResponse getByName(String name);
    List<ProductResponse> getByCooperative(Long cooperativeId);
    List<ProductResponse> getByCategory(Long categoryId);
//    List<ProductResponse> getByRegion(Long regionId);
    List<ProductResponse> getAll();
    public ProductResponse getById(Long id);

    void deleteById(Long id);
}
