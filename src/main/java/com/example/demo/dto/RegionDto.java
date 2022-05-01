package com.example.demo.dto;

import com.example.demo.entities.Cooperative;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class RegionDto {

    private Long id;
    private String name;

    List<CooperativeDto> cooperatives;

}
