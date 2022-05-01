package com.example.demo.dto;

import com.example.demo.entities.*;

import java.util.ArrayList;
import java.util.List;

public class ToDto {

    public static CooperativeDto toCooperativeDto(Cooperative cooperative){
        CooperativeDto cooperativeDto = new CooperativeDto();

        cooperativeDto.setName(cooperative.getName());
        cooperativeDto.setId(cooperative.getId());

        List<ProduitDto> produitList = new ArrayList<>();
        for (Produit produit : cooperative.getProduits() ) {
            produitList.add(toProduitDto(produit));
        }
        cooperativeDto.setProduits(produitList);

        return cooperativeDto;
    }

    public static ProduitDto toProduitDto(Produit produit){
        ProduitDto produitDto = new ProduitDto();
        produitDto.setIdProduit(produit.getId());
        produitDto.setName(produit.getName());
        produitDto.setDescription(produit.getDescription());
        produitDto.setCategory(produit.getCategory().getLabel());
        // produitDto.setCooperative(produit.getCooperative().getName());
        return produitDto;
    }

    public static LigneCommandDto toLigneCommandDto(LigneCommand ligneCommand){

        LigneCommandDto ligneCommandDto = new LigneCommandDto();
        ligneCommandDto.setId(ligneCommand.getId());
        ligneCommandDto.setProduit(toProduitDto(ligneCommand.getProduit()).getName());
        return ligneCommandDto;
    }

    public static OrigineDto toOrigineDto(Origine origine){
        OrigineDto origineDto = new OrigineDto();

        origineDto.setId(origine.getId());
        origineDto.setLabel(origine.getLabel());
        return origineDto;
    }

    public static RegionDto toRegionDto(Region region){
        RegionDto regionDto = new RegionDto();

        regionDto.setId(region.getId());
        regionDto.setName(region.getName());
        List<CooperativeDto> cooperativeDtoList = new ArrayList<>();
        for (Cooperative cooperative : region.getCooperatives() ) {
            cooperativeDtoList.add(toCooperativeDto(cooperative));
        }
        regionDto.setCooperatives( cooperativeDtoList);

        return regionDto;
    }

    public static CommandDto toCommandDto(Command command){
        CommandDto commandDto = new CommandDto();

        commandDto.setId(command.getId());
        commandDto.setCooperative(toCooperativeDto(command.getCooperative()));

        return commandDto;
    }

    public static ClientDto toClientDto(Client client ){

        ClientDto clientDto = new ClientDto();
        clientDto.setId(client.getId());
        List<Long> commandDtos = new ArrayList<>();
        for (Command command : client.getCommands() ) {
            commandDtos.add(toCommandDto(command).getId());
        }
       // clientDto.setCommands(commandDtos);

        return clientDto;
    }

    public static MatiereDto toMatiereDto(MatierePremiere matiere){
        MatiereDto matiereDto = new MatiereDto();

        matiereDto.setId(matiere.getId());
        matiereDto.setName(matiere.getName());
        matiereDto.setDescription(matiere.getDescription());
        return matiereDto;
    }
}
