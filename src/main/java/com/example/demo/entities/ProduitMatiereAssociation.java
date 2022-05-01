package com.example.demo.entities;

import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class ProduitMatiereAssociation {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private Long id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idProduit", referencedColumnName = "id")
    private Produit produit;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idMatiere", referencedColumnName = "id")
    private MatierePremiere matierePremiere;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idOrigine", referencedColumnName = "id")
    private Origine origine;

}
