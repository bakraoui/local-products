package com.example.demo.dto;

import com.example.demo.entities.Command;
import com.example.demo.entities.Produit;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class LigneCommandDto {

    Long id;
    String produit;
}
