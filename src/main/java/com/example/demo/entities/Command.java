package com.example.demo.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Command {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;


    @ManyToOne
    @JoinColumn(
            name = "id_cooperative",
            referencedColumnName = "id"
    )
    private Cooperative cooperative;



    @OneToMany(cascade =  CascadeType.ALL,mappedBy = "command")
    List<LigneCommand> lignes;



    @ManyToOne
    @JoinColumn(
            name = "id_client",
            referencedColumnName = "id"
    )
    private Client client;

}
