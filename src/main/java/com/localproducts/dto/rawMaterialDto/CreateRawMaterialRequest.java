package com.localproducts.dto.rawMaterialDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateRawMaterialRequest {

    private String name;
    private String description;
    private Long originId;

}
