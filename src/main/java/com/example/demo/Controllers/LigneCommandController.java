package com.example.demo.Controllers;


import com.example.demo.dto.LigneCommandDto;
import com.example.demo.entities.Client;
import com.example.demo.entities.Command;
import com.example.demo.entities.LigneCommand;
import com.example.demo.entities.Produit;
import com.example.demo.service.Implementation.LigneImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lignes")
public class LigneCommandController {
    
    @Autowired
    LigneImp ligneImp;


    @PostMapping("")
    public String addLigneCommand(@RequestBody LigneCommand LigneCommand){
        try {
            ligneImp.create(LigneCommand);
            return "LigneCommand added with success";
        }catch (Exception e){
            return e.getMessage();
        }
    }

//    @GetMapping("/client")
//    public List<LigneCommand> getLigneCommandByClient(@RequestBody Client client){
//        return ligneImp.findByClient(client);
//    }

    @GetMapping("/command")
    public List<LigneCommandDto> getLigneCommandByCommand(@RequestBody  Command command){
        return ligneImp.findByCommand(command);
    }

    @GetMapping("/produit")
    public List<LigneCommandDto> getLigneCommandByProduit(@RequestBody Produit produit){
        return ligneImp.findByProduit(produit);
    }


    @GetMapping("/{id}")
    public LigneCommandDto getLigneCommandById(@PathVariable Long id){
        return  ligneImp.findById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteLigneCommand(@PathVariable("id") Long id){
        try {
            ligneImp.deleteById(id);
            return "Cooperative deleted suuccessfully";
        }catch (Exception e){
            return e.getMessage();
        }
    }

    @PutMapping("")
    public String updateLigneCommand(@RequestBody LigneCommand LigneCommand){
        try {
            ligneImp.update(LigneCommand);
            return "Cooperative updated successfully";
        }catch (Exception e){
            return e.getMessage();
        }

    }
    
}
