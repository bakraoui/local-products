package com.example.demo.service.Interfaces;

import com.example.demo.dto.ProduitDto;
import com.example.demo.entities.*;

import java.util.List;

public  interface ProduitInterface {

    public  void addProduit(Produit produit);
    public void addProduits(Produit... produit);
    public Produit getByName(String name);
    public  List<ProduitDto> getByCooperative(Cooperative cooperative);
    public List<ProduitDto> getByCategory(Category category);
    public List<ProduitDto> getByRegion(Region region);
    public List<ProduitDto> getByMatierePremiere(MatierePremiere matierePremiere);
    public List<ProduitDto> getByMatierePremiereOrigine(Origine origine);
    public List<ProduitDto> getAll();
    public ProduitDto getById(Long id);

    void deleteById(Long id);
}
