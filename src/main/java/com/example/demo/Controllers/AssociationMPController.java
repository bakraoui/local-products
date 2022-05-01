package com.example.demo.Controllers;

import com.example.demo.entities.ProduitMatiereAssociation;
import com.example.demo.service.Implementation.ProduitMatiereAssociationImp;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@NoArgsConstructor
@AllArgsConstructor
@RestController
@RequestMapping("/api/pmasso")
public class AssociationMPController {
    @Autowired
    ProduitMatiereAssociationImp produitMatiereAssociationImp;

    @PostMapping("")
    public String create(@RequestBody ProduitMatiereAssociation ...produitMatiereAssociation){
        try {
            produitMatiereAssociationImp.addProduitMatiereAssociation(produitMatiereAssociation);
            return "ok";
        }catch (Exception e){
            return e.getMessage();
        }
    }
}
