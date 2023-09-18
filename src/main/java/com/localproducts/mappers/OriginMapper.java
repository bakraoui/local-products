package com.localproducts.mappers;

import com.localproducts.dto.originDto.CreateOriginRequest;
import com.localproducts.dto.originDto.OriginResponse;
import com.localproducts.entities.Origin;

public class OriginMapper {

    public static OriginResponse originToOriginResponse(Origin origin) {
        return OriginResponse.builder()
                .id(origin.getId())
                .label(origin.getLabel())
                .build();
    }

    public static Origin originRequestTOrigin(CreateOriginRequest request) {
        return Origin.builder()
                .label(request.getLabel())
                .build();
    }
}
