package com.localproducts.service.Interfaces;

import com.localproducts.dto.clientDto.CreateClientRequest;
import com.localproducts.entities.Client;

import java.util.List;

public interface IClientService {
    void create(CreateClientRequest request);

    List<Client> findAll();
}
