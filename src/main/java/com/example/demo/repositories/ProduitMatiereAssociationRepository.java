package com.example.demo.repositories;


import com.example.demo.entities.MatierePremiere;
import com.example.demo.entities.ProduitMatiereAssociation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ProduitMatiereAssociationRepository extends JpaRepository<ProduitMatiereAssociation,Long> {
    public List<ProduitMatiereAssociation> findByMatierePremiere(MatierePremiere matierePremiere);
}
