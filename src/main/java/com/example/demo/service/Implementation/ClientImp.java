package com.example.demo.service.Implementation;

import com.example.demo.configuration.security.AppRole;
import com.example.demo.configuration.security.service.AppRoleRepository;
import com.example.demo.entities.Client;
import com.example.demo.repositories.ClientRepository;
import com.example.demo.service.Interfaces.ClientInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class ClientImp implements ClientInterface {

    @Autowired
    ClientRepository clientRepository;
    @Autowired
     AppRoleRepository appRoleRepository;

    @Override
    public void create(Client client){
        AppRole clientRole = appRoleRepository.findByName("CLIENT") ;
        if (clientRole == null) {
            clientRole = new AppRole();
            clientRole.setName("CLIENT");
            appRoleRepository.save(clientRole);
            clientRole = appRoleRepository.findByName("CLIENT");
        }
        Set<AppRole> appRole = client.getAppUser().getRoles();
        appRole.add(clientRole);
        client.getAppUser().setRoles(appRole);

        clientRepository.save(client);
    }

    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();
    }
}
