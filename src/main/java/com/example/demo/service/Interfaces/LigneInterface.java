package com.example.demo.service.Interfaces;

import com.example.demo.dto.LigneCommandDto;
import com.example.demo.entities.Client;
import com.example.demo.entities.Command;
import com.example.demo.entities.LigneCommand;
import com.example.demo.entities.Produit;

import java.util.List;

public interface LigneInterface {

    public void create(LigneCommand ligne);
    public void delete(LigneCommand ligne);
    public void deleteById(Long id);
    public LigneCommandDto findById(Long id);
//    public List<LigneCommand> findByClient(Client client);
    public List<LigneCommandDto> findByProduit(Produit produit);
    public List<LigneCommandDto> findByCommand(Command command);

    void update(LigneCommand ligneCommand);
}
