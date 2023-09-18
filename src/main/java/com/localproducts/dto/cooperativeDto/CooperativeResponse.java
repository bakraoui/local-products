package com.localproducts.dto.cooperativeDto;

import com.localproducts.dto.regionDto.RegionResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CooperativeResponse {

    private String name;
    private List<RegionResponse> regions;
}
