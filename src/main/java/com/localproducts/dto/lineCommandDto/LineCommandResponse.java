package com.localproducts.dto.lineCommandDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LineCommandResponse {

    private Long id;
    private Long productId;
    private String productName;
    private String description;
    private String cooperativeName;
    private String categoryLabel ;


}
