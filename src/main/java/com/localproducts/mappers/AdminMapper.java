package com.localproducts.mappers;

import com.localproducts.security.AppRole;
import com.localproducts.security.AppUser;
import com.localproducts.dto.adminDto.CreateAdminRequest;
import com.localproducts.entities.Admin;

import java.util.Set;

public class AdminMapper {

    public static Admin adminRequestToAdmin(CreateAdminRequest request, Set<AppRole> roles){
        AppUser appUser = AppUser.builder()
                .username(request.getUsername())
                .password(request.getPassword())
                .roles(roles)
                .build();

        return Admin.builder()
                .name(request.getName())
                .address(request.getAddress())
                .appUser(appUser)
                .build();
    }
}
