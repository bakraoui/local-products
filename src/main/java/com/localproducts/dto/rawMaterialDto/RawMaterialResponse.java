package com.localproducts.dto.rawMaterialDto;

import com.localproducts.dto.originDto.OriginResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RawMaterialResponse {

    private Long id;
    private String name;
    private String description;

    private Long originId;
    private String originLabel;
}
