package com.localproducts.mappers;

import com.localproducts.dto.regionDto.CreateRegionRequest;
import com.localproducts.dto.regionDto.RegionResponse;
import com.localproducts.entities.Region;

public class RegionMapper {

    public static Region regionRequestToRegion(CreateRegionRequest request) {
        return Region.builder()
                .name(request.getName())
                .build();
    }

    public static RegionResponse regionToRegionResponse(Region region) {
        return RegionResponse.builder()
                .id(region.getId())
                .name(region.getName())
                .build();
    }
}
