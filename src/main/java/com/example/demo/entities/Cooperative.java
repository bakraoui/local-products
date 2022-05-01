package com.example.demo.entities;

import com.example.demo.configuration.security.AppUser;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Table(
        uniqueConstraints = @UniqueConstraint(
                name = "unique_name",
                columnNames = "name"
        )
)
public class Cooperative {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;


    @ManyToMany
    @JoinTable(
            name = "cooperative_region",
            joinColumns =@JoinColumn(
                    name = "id_cooperative",
                    referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "id_region",
                    referencedColumnName = "id"
            )
    )
    List<Region> regions;


    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private AppUser appUser;

    @OneToMany(cascade =  CascadeType.ALL,mappedBy ="cooperative",fetch = FetchType.LAZY)
    private  List<Produit> produits ;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "cooperative")
    List<Command> commands;




}
