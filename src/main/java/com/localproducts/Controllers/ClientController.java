package com.localproducts.Controllers;

import com.localproducts.dto.clientDto.CreateClientRequest;
import com.localproducts.entities.Client;
import com.localproducts.service.Interfaces.IClientService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    private final IClientService clientService;

    public ClientController(IClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody CreateClientRequest request){
        clientService.create(request);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Client> getAll(){
        return clientService.findAll();
    }
}
