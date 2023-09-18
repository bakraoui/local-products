package com.localproducts.dto.cooperativeDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CreateCooperativeRequest {

    private String name;
    private String username;
    private String password;
    private List<Long> regions;

}
