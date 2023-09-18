package com.localproducts.service.Implementation;

import com.localproducts.security.AppRole;
import com.localproducts.security.AppUser;
import com.localproducts.security.service.AppRoleRepository;
import com.localproducts.security.service.AppUserRepository;
import com.localproducts.dto.adminDto.CreateAdminRequest;
import com.localproducts.entities.Admin;
import com.localproducts.exceptions.RecordNotValidException;
import com.localproducts.exceptions.RecordExistException;
import com.localproducts.helpers.adminHelper.AdminValidatorResult;
import com.localproducts.mappers.AdminMapper;
import com.localproducts.repositories.AdminRepository;
import com.localproducts.service.Interfaces.IAdminService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static com.localproducts.helpers.adminHelper.AdminValidatorResult.SUCCESS;
import static com.localproducts.helpers.adminHelper.CreateAdminRequestHandler.*;

@Service
@Transactional
public class AdminService implements IAdminService {

     private final AdminRepository adminRepository;
     private final AppRoleRepository appRoleRepository;
     private final AppUserRepository appUserRepository;

    public AdminService(AdminRepository adminRepository, AppRoleRepository appRoleRepository, AppUserRepository appUserRepository) {
        this.adminRepository = adminRepository;
        this.appRoleRepository = appRoleRepository;
        this.appUserRepository = appUserRepository;
    }

    public void save(CreateAdminRequest request){
        //TODO Input Validation
        validateAdminRequest(request);

        checkIfUserExist(request.getUsername());

        Set<AppRole> roles = createAdminRoles();

        Admin admin = AdminMapper.adminRequestToAdmin(request, roles);

        adminRepository.save(admin);
    }

    private void validateAdminRequest(CreateAdminRequest request) {
        AdminValidatorResult result = isUsernameValid()
                .and(isNameValid())
                .and(isAddressValid())
                .and(isPasswordValid())
                .apply(request);

        if (!result.equals(SUCCESS)) {
            throw new RecordNotValidException(result.getMessage());
        }
    }


    private AppRole saveAdminRoleIfNotExist() {
        Optional<AppRole> adminRole = appRoleRepository.findByName("ADMIN") ;

        if(adminRole.isPresent()) {
            return adminRole.get();
        }

        AppRole admin = new AppRole();
        admin.setName("ADMIN");
        return appRoleRepository.save(admin);

    }

    private Set<AppRole> createAdminRoles() {
        AppRole role = saveAdminRoleIfNotExist();
        Set<AppRole> roles = new HashSet<>();
        roles.add(role);
        return roles;
    }

    private void checkIfUserExist(String username){
        Optional<AppUser> appUser = appUserRepository.findByUsername(username);
        if (appUser.isPresent()) {
            throw new RecordExistException("That username already used.");
        }
    }

}
