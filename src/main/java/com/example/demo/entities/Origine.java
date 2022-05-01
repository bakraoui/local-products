package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(
        uniqueConstraints = @UniqueConstraint(
                name = "unique_name",
                columnNames = "label"
        )
)
public class Origine {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String label;


    @OneToMany(
            cascade = {CascadeType.ALL},
            mappedBy = "origine"
    )
    private List<ProduitMatiereAssociation> produitMatiereAssociations;



}
