package com.localproducts.mappers;

import com.localproducts.dto.clientDto.CreateClientRequest;
import com.localproducts.entities.Client;
import com.localproducts.security.AppRole;
import com.localproducts.security.AppUser;

import java.util.Set;

public class ClientMapper {

    public static Client clientRequestToClient(CreateClientRequest request, Set<AppRole> roles) {
        AppUser user = AppUser.builder()
                .username(request.getUsername())
                .password(request.getPassword())
                .roles(roles)
                .build();

        return Client.builder()
                .appUser(user)
                .name(request.getName())
                .address(request.getAddress())
                .build();
    }
}
