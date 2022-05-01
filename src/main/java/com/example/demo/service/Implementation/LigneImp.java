package com.example.demo.service.Implementation;

import com.example.demo.dto.LigneCommandDto;
import com.example.demo.dto.ToDto;
import com.example.demo.entities.Client;
import com.example.demo.entities.Command;
import com.example.demo.entities.LigneCommand;
import com.example.demo.entities.Produit;
import com.example.demo.repositories.LigneRepository;
import com.example.demo.service.Interfaces.LigneInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LigneImp implements LigneInterface {
    @Autowired
    LigneRepository ligneRepository;

    @Override
    public void create(LigneCommand ligne) {
        ligneRepository.save(ligne);
    }

    @Override
    public void delete(LigneCommand ligne) {
        ligneRepository.delete(ligne);
    }

    @Override
    public void deleteById(Long id) {
        ligneRepository.deleteById(id);
    }

    @Override
    public LigneCommandDto findById(Long id) {
        LigneCommand ligneCommand = ligneRepository.findById(id).stream().findFirst().orElse(null);
        return ToDto.toLigneCommandDto(ligneCommand);
    }



    @Override
    public List<LigneCommandDto> findByProduit(Produit produit) {
        List<LigneCommand> ligneCommands = ligneRepository.findByProduit(produit);
        List<LigneCommandDto> ligneCommandDtos = new ArrayList<>();
        for (LigneCommand ligne: ligneCommands ) {
            ligneCommandDtos.add(ToDto.toLigneCommandDto(ligne));
        }
        return ligneCommandDtos;
    }

    @Override
    public List<LigneCommandDto> findByCommand(Command command) {
        List<LigneCommand> ligneCommands =  ligneRepository.findByCommand(command);

        List<LigneCommandDto> ligneCommandDtos = new ArrayList<>();
        for (LigneCommand ligne: ligneCommands ) {
            ligneCommandDtos.add(ToDto.toLigneCommandDto(ligne));
        }
        return ligneCommandDtos;
    }

    @Override
    public void update(LigneCommand ligneCommand) {
        ligneRepository.save(ligneCommand);
    }
}
