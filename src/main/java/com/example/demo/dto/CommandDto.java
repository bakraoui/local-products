package com.example.demo.dto;

import com.example.demo.entities.Client;
import com.example.demo.entities.Cooperative;
import com.example.demo.entities.LigneCommand;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommandDto {

    private Long id;

    private CooperativeDto cooperative;

    List<LigneCommandDto> lignes;

    // private ClientDto client;
}
