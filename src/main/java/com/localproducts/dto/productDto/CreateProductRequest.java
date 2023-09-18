package com.localproducts.dto.productDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CreateProductRequest {

    private String name;
    private String description;
    private List<Long> rawMaterialIds;
    private Long cooperativeId;
    private Long categoryId;
}
