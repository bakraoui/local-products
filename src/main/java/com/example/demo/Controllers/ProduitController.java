package com.example.demo.Controllers;

import com.example.demo.dto.ProduitDto;
import com.example.demo.entities.*;
import com.example.demo.service.Implementation.ProduitImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produits")
public class ProduitController {

    @Autowired
    ProduitImp produitImp;

    @PostMapping("")
    public void create(@RequestBody Produit ...produit){
          produitImp.addProduits(produit);
    }

    @GetMapping("")
    public List<ProduitDto> getAll(){
       return produitImp.getAll();
    }

    @GetMapping("/{id}")
    public ProduitDto getById(@PathVariable Long id){
        return  produitImp.getById(id);
    }

    @GetMapping("/cooperative")
    public List<ProduitDto> getByCooperative(@RequestBody Cooperative cooperative){
        return produitImp.getByCooperative(cooperative);
    }

    @GetMapping("/category")
    public List<ProduitDto> getByCategory(@RequestBody Category category){
        return produitImp.getByCategory(category);
    }

    @GetMapping("/matiere")
    public List<ProduitDto> getByMatiere(@RequestBody MatierePremiere matierePremiere){
        return produitImp.getByMatierePremiere(matierePremiere);
    }

    @GetMapping("/region")
    public List<ProduitDto> getByRegion(@RequestBody Region region){
        return produitImp.getByRegion(region);
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable Long id){
        produitImp.deleteById(id);
        return "deleted";
    }
}
