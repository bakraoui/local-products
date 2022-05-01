package com.example.demo.service.Implementation;


import com.example.demo.entities.ProduitMatiereAssociation;
import com.example.demo.repositories.ProduitMatiereAssociationRepository;
import com.example.demo.service.Interfaces.ProduitMatiereAssociationInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service

public class ProduitMatiereAssociationImp implements ProduitMatiereAssociationInterface {

    @Autowired
    ProduitMatiereAssociationRepository produitMatiereAssociationRepository;


    public void addProduitMatiereAssociation(ProduitMatiereAssociation produitMatiereAssociation) {
            produitMatiereAssociationRepository.save(produitMatiereAssociation);
    }

    public void addProduitMatiereAssociation(ProduitMatiereAssociation...produitMatiereAssociation) {
        for (ProduitMatiereAssociation pma:produitMatiereAssociation ) {
            produitMatiereAssociationRepository.save(pma);
        }
    }

}
