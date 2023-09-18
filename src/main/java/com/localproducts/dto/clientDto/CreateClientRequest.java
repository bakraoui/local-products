package com.localproducts.dto.clientDto;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CreateClientRequest {

    private String username ;
    private String password ;
    private String name;
    private  String address;

}
