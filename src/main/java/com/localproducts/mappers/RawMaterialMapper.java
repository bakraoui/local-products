package com.localproducts.mappers;

import com.localproducts.dto.rawMaterialDto.CreateRawMaterialRequest;
import com.localproducts.dto.rawMaterialDto.RawMaterialResponse;
import com.localproducts.entities.Origin;
import com.localproducts.entities.RawMaterial;

public class RawMaterialMapper {


    public static RawMaterial createRawMaterialRequestToRawMaterial(CreateRawMaterialRequest request, Origin origin) {
        return RawMaterial.builder()
                .name(request.getName())
                .description(request.getDescription())
                .origin(origin)
                .build();
    }

    public static RawMaterialResponse rawMaterialToRawMaterialResponse(RawMaterial material) {
        return RawMaterialResponse.builder()
                .id(material.getId())
                .name(material.getName())
                .description(material.getDescription())
                .originId(material.getOrigin().getId())
                .originLabel(material.getOrigin().getLabel())
                .build();
    }


}
