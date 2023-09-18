package com.localproducts.dto.lineCommandDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateLIneCommandRequest {

    private Long quantity;
    private Long productId;
    private Long commandId;

}
