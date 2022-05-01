package com.example.demo.dto;

import com.example.demo.entities.ProduitMatiereAssociation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MatiereDto {

    private Long id;
    private String name;
    private String description;


}
