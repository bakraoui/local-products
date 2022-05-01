package com.example.demo.service.Interfaces;


import com.example.demo.dto.MatiereDto;
import com.example.demo.entities.MatierePremiere;

import java.util.List;

public  interface MatierePremiereInterface {


    void create(MatierePremiere... matierePremiere);

    MatiereDto getById(long id);

    MatiereDto getByName(String name);

    void update(MatierePremiere matierePremiere);

    void delete(MatierePremiere matierePremiere);

    void deleteById(Long id);

    List<MatiereDto> getAll();
}
