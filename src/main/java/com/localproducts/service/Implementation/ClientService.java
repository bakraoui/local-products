package com.localproducts.service.Implementation;

import com.localproducts.dto.clientDto.CreateClientRequest;
import com.localproducts.exceptions.RecordExistException;
import com.localproducts.exceptions.RecordNotValidException;
import com.localproducts.helpers.clientHelper.ClientValidatorResult;
import com.localproducts.mappers.ClientMapper;
import com.localproducts.security.AppRole;
import com.localproducts.security.AppUser;
import com.localproducts.security.service.AppRoleRepository;
import com.localproducts.entities.Client;
import com.localproducts.repositories.ClientRepository;
import com.localproducts.security.service.AppUserRepository;
import com.localproducts.service.Interfaces.IClientService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static com.localproducts.helpers.clientHelper.ClientValidatorResult.SUCCESS;
import static com.localproducts.helpers.clientHelper.CreateClientRequestHandler.*;

@Service
public class ClientService implements IClientService {

    private final ClientRepository clientRepository;
    private final AppRoleRepository appRoleRepository;
    private final AppUserRepository appUserRepository;

    public ClientService(ClientRepository clientRepository, AppRoleRepository appRoleRepository, AppUserRepository appUserRepository) {
        this.clientRepository = clientRepository;
        this.appRoleRepository = appRoleRepository;
        this.appUserRepository = appUserRepository;
    }

    @Override
    public void create(CreateClientRequest request){

        validateClientRequest(request);

        Optional<AppUser> user = appUserRepository.findByUsername(request.getUsername());
        if (user.isPresent()){
            throw new RecordExistException("The given username is already used");
        }

        Set<AppRole> roles = createClientRoles();
        Client client = ClientMapper.clientRequestToClient(request, roles);


        clientRepository.save(client);
    }

    private void validateClientRequest(CreateClientRequest request) {
        ClientValidatorResult result = isUsernameValid()
                .and(isPasswordValid())
                .and(isNameValid())
                .and(isAddressValid())
                .apply(request);

        if (!result.equals(SUCCESS)) {
            throw new RecordNotValidException(result.getMessage());
        }
    }

    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    private AppRole saveClientRoleIfNotExist() {
        Optional<AppRole> clientRole = appRoleRepository.findByName("CLIENT");
        if (clientRole.isPresent()){
            return clientRole.get();
        }

        AppRole role = new AppRole();
        role.setName("CLIENT");

        return appRoleRepository.save(role);
    }

    private Set<AppRole> createClientRoles() {
        AppRole role = saveClientRoleIfNotExist();

        Set<AppRole> roles = new HashSet<>();
        roles.add(role);
        return roles;
    }
}
