package com.example.demo.repositories;

import com.example.demo.dto.CooperativeDto;
import com.example.demo.entities.Category;
import com.example.demo.entities.Cooperative;
import com.example.demo.entities.Produit;
import com.example.demo.entities.ProduitMatiereAssociation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProduitRepository extends JpaRepository<Produit,Long> {
    public Produit findByName(String name);
    public List<Produit> findByCooperative(CooperativeDto cooperative);
    public List<Produit> findByCategory(Category category);
    public List<Produit> findByProduitMatiereAssociations(ProduitMatiereAssociation produitMatiereAssociation);
}
