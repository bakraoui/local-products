package com.example.demo.service.Implementation;

import com.example.demo.dto.CooperativeDto;
import com.example.demo.dto.ProduitDto;
import com.example.demo.dto.ToDto;
import com.example.demo.entities.*;
import com.example.demo.repositories.ProduitMatiereAssociationRepository;
import com.example.demo.repositories.ProduitRepository;
import com.example.demo.service.Interfaces.ProduitInterface;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Service

public class ProduitImp implements ProduitInterface {

    @Autowired
    ProduitRepository produitRepository;
    @Autowired
    CooperativeImp cooperativeImp;
    @Autowired
    ProduitMatiereAssociationRepository  produitMatiereAssociationRepository;

    @Override
    public void addProduit(Produit produit) {
        produitRepository.save(produit);
    }

    @Override
    public void addProduits(Produit... produit) {
        for (Produit pr : produit ) {
            produitRepository.save(pr);
        }
    }

    @Override
    public Produit getByName(String name) {
        return produitRepository.findByName(name);
    }

    @Override
    public List<ProduitDto> getByCooperative(Cooperative cooperative) {
        CooperativeDto cooperativeDto = ToDto.toCooperativeDto(cooperative);
        List<Produit> produits =  produitRepository.findByCooperative(cooperativeDto);
        List<ProduitDto> produitDtos = new ArrayList<>();
        for (Produit produit :produits) {
            ProduitDto produitDto = ToDto.toProduitDto(produit);
            produitDtos.add(produitDto);
        }
        return produitDtos;
    }

    @Override
    public List<ProduitDto> getByCategory(Category category) {
        List<Produit> produits=  produitRepository.findByCategory(category);
        List<ProduitDto> produitDtos = new ArrayList<>();
        for (Produit produit :produits) {
            ProduitDto produitDto = ToDto.toProduitDto(produit);
            produitDtos.add(produitDto);
        }
        return produitDtos;
    }

    @Override
    public List<ProduitDto> getByRegion(Region region) {
        List<CooperativeDto> cooperatives = cooperativeImp.FilterByRegion(region.getName());
        List<Produit> produits = new ArrayList<>();
        for (CooperativeDto coop: cooperatives) {
            produits.addAll(
                    produitRepository.findByCooperative(coop)
            );
        }
        List<ProduitDto> produitDtos = new ArrayList<>();
        for (Produit produit :produits) {
            ProduitDto produitDto = ToDto.toProduitDto(produit);
            produitDtos.add(produitDto);
        }
        return produitDtos;
    }

    @Override
    public List<ProduitDto> getByMatierePremiere(MatierePremiere matierePremiere) {
        List<ProduitMatiereAssociation> produitMatiereAssociations =
                produitMatiereAssociationRepository.findByMatierePremiere(matierePremiere);
        List<Produit> produits = new ArrayList<>();
        for (ProduitMatiereAssociation pma:produitMatiereAssociations ) {
            produits.addAll(
                    produitRepository.findByProduitMatiereAssociations(pma)
            );
        }
        List<ProduitDto> produitDtos = new ArrayList<>();
        for (Produit produit :produits) {
            ProduitDto produitDto = ToDto.toProduitDto(produit);
            produitDtos.add(produitDto);
        }
        return produitDtos;
    }

    @Override
    public List<ProduitDto> getByMatierePremiereOrigine(Origine origine) {
        return null;
    }

    @Override
    public List<ProduitDto> getAll() {
        List<Produit>  produits = produitRepository.findAll();
        List<ProduitDto> produitDtos = new ArrayList<>();
        for (Produit produit: produits) {
            ProduitDto produitDto = ToDto.toProduitDto(produit);
            produitDtos.add(produitDto);
        }
        return produitDtos;
    }

    @Override
    public ProduitDto getById(Long id) {

        return ToDto.toProduitDto(produitRepository.findById(id)
                .stream().findFirst().orElse(null));
    }

    @Override
    public void deleteById(Long id) {
        produitRepository.deleteById(id);
    }


}
