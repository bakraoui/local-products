package com.example.demo.service.Implementation;

import com.example.demo.configuration.security.AppRole;
import com.example.demo.configuration.security.service.AppRoleRepository;
import com.example.demo.entities.Admin;
import com.example.demo.repositories.AdminRepository;
import com.example.demo.service.Interfaces.AdminInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class AdminImp implements AdminInterface {

    @Autowired
     AdminRepository adminRepository;

    @Autowired
     AppRoleRepository appRoleRepository;

    public void addAdmin(Admin admin){
        AppRole adminRole = appRoleRepository.findByName("ADMIN") ;
        if (adminRole == null) {
            adminRole = new AppRole();
            adminRole.setName("ADMIN");
            appRoleRepository.save(adminRole);
            adminRole = appRoleRepository.findByName("ADMIN");
        }
        Set<AppRole> appRole = admin.getAppUser().getRoles();
        appRole.add(adminRole);
        admin.getAppUser().setRoles(appRole);

        adminRepository.save(admin);
    }
}
