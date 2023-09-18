package com.localproducts.mappers;

import com.localproducts.dto.cooperativeDto.CooperativeResponse;
import com.localproducts.dto.cooperativeDto.CreateCooperativeRequest;
import com.localproducts.entities.Cooperative;
import com.localproducts.entities.Region;
import com.localproducts.security.AppRole;
import com.localproducts.security.AppUser;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CooperativeMapper {

    public static Cooperative cooperativeRequestToCooperative(CreateCooperativeRequest request, Set<AppRole> roles, List<Region> regions) {
        AppUser user = AppUser.builder()
                .username(request.getUsername())
                .password(request.getPassword())
                .roles(roles)
                .build();

        return Cooperative.builder()
                .appUser(user)
                .name(request.getName())
                .regions(regions)
                .build();
    }

    public static CooperativeResponse cooperativeTocooperativeResponse(Cooperative cooperative){
        return CooperativeResponse.builder()
                .name(cooperative.getName())
                .regions(
                        cooperative.getRegions().stream().map( RegionMapper::regionToRegionResponse)
                                .collect(Collectors.toList())
                )
                .build();
    }
}
