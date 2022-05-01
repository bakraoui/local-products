package com.example.demo.service.Interfaces;

import com.example.demo.entities.Client;

import java.util.List;

public interface ClientInterface {
    void create(Client client);

    List<Client> findAll();
}
