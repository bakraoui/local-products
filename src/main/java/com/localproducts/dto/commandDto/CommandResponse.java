package com.localproducts.dto.commandDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CommandResponse {

    private Long id;
    private boolean isPayed;

    private Long cooperativeId;
    private String cooperativeName;

    private Long clientId;
    private String clientName;
    private  String clientAddress;

}
