package com.localproducts.service.Implementation;

import com.localproducts.dto.productDto.CreateProductRequest;
import com.localproducts.dto.productDto.ProductResponse;
import com.localproducts.entities.Category;
import com.localproducts.entities.Product;
import com.localproducts.entities.RawMaterial;
import com.localproducts.exceptions.RecordNotExistException;
import com.localproducts.mappers.ProductMapper;
import com.localproducts.repositories.CategoryRepository;
import com.localproducts.repositories.CooperativeRepository;
import com.localproducts.repositories.ProductRepository;
import com.localproducts.repositories.RawMaterialRepository;
import com.localproducts.service.Interfaces.IProductService;
import com.localproducts.entities.Cooperative;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class ProductService implements IProductService {

    private final ProductRepository productRepository;
    private final CooperativeRepository cooperativeRepository;
    private final CategoryRepository categoryRepository;
    private final RawMaterialRepository rawMaterialRepository;

    public ProductService(ProductRepository productRepository, CooperativeRepository cooperativeRepository, CategoryRepository categoryRepository, RawMaterialRepository rawMaterialRepository) {
        this.productRepository = productRepository;
        this.cooperativeRepository = cooperativeRepository;
        this.categoryRepository = categoryRepository;
        this.rawMaterialRepository = rawMaterialRepository;
    }

    @Override
    public void save(CreateProductRequest request) {
        Cooperative cooperative = cooperativeRepository.getById(request.getCooperativeId());
        Category category = categoryRepository.getById(request.getCategoryId());
        List<RawMaterial> rawMaterials = request.getRawMaterialIds()
                .stream()
                .map(rawMaterialRepository::getById)
                .collect(Collectors.toList());
        Product product = ProductMapper.createProductRequestToProduct(request, cooperative, category, rawMaterials);
        productRepository.save(product);
    }


    @Override
    public ProductResponse getByName(String name) {
        Product product =  productRepository.findByName(name)
                .stream().findFirst().orElseThrow(() -> new RecordNotExistException("Product not found"));

        return ProductMapper.productToProductResponse(product);
    }

    @Override
    public List<ProductResponse> getByCooperative(Long cooperativeId) {
        Cooperative cooperative = cooperativeRepository.findById(cooperativeId)
                .stream().findFirst()
                .orElseThrow(() -> new RecordNotExistException("No cooperative Found with given Id"));

        List<Product> products =  productRepository.findByCooperative(cooperative);

        return products.stream()
                .map(ProductMapper::productToProductResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductResponse> getByCategory(Long categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .stream().findFirst()
                .orElseThrow(() -> new RecordNotExistException("No Category Found with given Id"));
        List<Product> products =  productRepository.findByCategory(category);

        return products.stream()
                .map(ProductMapper::productToProductResponse)
                .collect(Collectors.toList());
    }

//    @Override
//    public List<ProductResponse> getByRegion(Long regionId) {
//        Region region = regionRepository.findById(regionId)
//                .orElseThrow(() -> new RecordNotExistException("No Region Found with given Id"));
//        List<Product> products =  productRepository.findByRegion(region);
//
//        return products.stream()
//                .map(ProductMapper::productToProductResponse)
//                .collect(Collectors.toList());
//    }

    @Override
    public List<ProductResponse> getAll() {
        List<Product> products = productRepository.findAll();

        return products.stream()
                .map(ProductMapper::productToProductResponse)
                .collect(Collectors.toList());
    }

    @Override
    public ProductResponse getById(Long id) {
        Product product = productRepository.findById(id)
                .stream().findFirst().orElseThrow(() -> new RecordNotExistException("Product not found"));
        return ProductMapper.productToProductResponse(product);
    }

    @Override
    public void deleteById(Long id) {
        Product product = productRepository.findById(id)
                        .stream().findFirst()
                        .orElseThrow(() -> new RecordNotExistException("Product Not Found to delete."));
        productRepository.delete(product);
    }


}
