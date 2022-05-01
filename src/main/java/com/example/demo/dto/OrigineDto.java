package com.example.demo.dto;

import com.example.demo.entities.ProduitMatiereAssociation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrigineDto {

    private Long id;
    private String label;

}
