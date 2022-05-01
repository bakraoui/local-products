package com.example.demo.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.io.Serializable;

@Data
@Embeddable
public class MatiereProduitAssocKey implements Serializable {


    @Column(
            name = "idProduit",
            nullable = false,
            updatable = false,
            insertable = false
    )
    private Long idProduit ;

    @Column(
            name = "idMatiere",
            nullable = false,
            updatable = false,
            insertable = false
    )
    private Long idMatiere;


}
