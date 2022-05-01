package com.example.demo.service.Interfaces;

import com.example.demo.dto.OrigineDto;
import com.example.demo.entities.Origine;

import java.util.List;

public interface OrigineInterface {

    public void addOrigines(Origine... origines);
    public List<OrigineDto> getAllOrigines();

    public void updateOrigine(Origine origine);
    public OrigineDto getOrigine(long id);

    OrigineDto getByName(String label);

    void delete(Origine origine);

    void deleteById(Long id);

    OrigineDto getById(Long id);
}
