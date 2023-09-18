package com.localproducts.dto.adminDto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CreateAdminRequest {

    private String username ;
    private String password ;
    private String name;
    private  String address;
}
