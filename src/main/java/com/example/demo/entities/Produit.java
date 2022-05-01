package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;



    @ManyToOne
    @JoinColumn(referencedColumnName = "id",name = "id_category")
    private Category category;


    @ManyToOne()
    @JoinColumn(
            name = "id_cooperative",
            referencedColumnName = "id"
    )
    private  Cooperative cooperative;

    @OneToMany
    List<LigneCommand> lignes;


    @OneToMany(
            cascade = {CascadeType.MERGE,CascadeType.PERSIST},
            mappedBy = "produit",fetch = FetchType.LAZY
    )
    List<ProduitMatiereAssociation> produitMatiereAssociations;




}
