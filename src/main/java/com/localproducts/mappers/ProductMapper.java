package com.localproducts.mappers;

import com.localproducts.dto.productDto.CreateProductRequest;
import com.localproducts.dto.productDto.ProductResponse;
import com.localproducts.dto.rawMaterialDto.RawMaterialResponse;
import com.localproducts.entities.Category;
import com.localproducts.entities.Cooperative;
import com.localproducts.entities.Product;
import com.localproducts.entities.RawMaterial;

import java.util.List;
import java.util.stream.Collectors;

public class ProductMapper {


    public static Product createProductRequestToProduct(CreateProductRequest request, Cooperative cooperative, Category category, List<RawMaterial> rawMaterials){
        return Product.builder()
                .name(request.getName())
                .description(request.getDescription())
                .cooperative(cooperative)
                .category(category)
                .rawMaterials(rawMaterials)
                .build();
    }

    public static ProductResponse productToProductResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .category(CategoryMapper.categoryToCategoryResponse(product.getCategory()))
                .cooperative(CooperativeMapper.cooperativeTocooperativeResponse(product.getCooperative()))
                .rawMaterials(
                        product.getRawMaterials().stream().map(RawMaterialMapper::rawMaterialToRawMaterialResponse)
                                .collect(Collectors.toList())
                )
                .build();
    }
}
