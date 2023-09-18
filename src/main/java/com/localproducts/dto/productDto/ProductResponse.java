package com.localproducts.dto.productDto;

import com.localproducts.dto.categoryDto.CategoryResponse;
import com.localproducts.dto.cooperativeDto.CooperativeResponse;
import com.localproducts.dto.rawMaterialDto.RawMaterialResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ProductResponse {

    private Long id;
    private String name;
    private String description;
    private List<RawMaterialResponse> rawMaterials;
    private CooperativeResponse cooperative;
    private CategoryResponse category;

}
