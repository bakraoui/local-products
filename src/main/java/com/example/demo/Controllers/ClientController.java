package com.example.demo.Controllers;

import com.example.demo.entities.Category;
import com.example.demo.entities.Client;
import com.example.demo.service.Implementation.ClientImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientController {
    @Autowired
    ClientImp clientImp;

    @PostMapping("")
    public String create(@RequestBody Client client){
        try {
            clientImp.create(client);
            return "success...";
        }catch (Exception e){
            return e.getMessage();
        }

    }

    @GetMapping("")
    public List<Client> getAll(){
        return clientImp.findAll();
    }
}
