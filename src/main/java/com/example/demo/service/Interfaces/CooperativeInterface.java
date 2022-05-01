package com.example.demo.service.Interfaces;

import com.example.demo.dto.CooperativeDto;
import com.example.demo.entities.Cooperative;

import java.util.List;

public interface CooperativeInterface {
    public void addCooperative(Cooperative cooperative);
    public void addCooperatives(Cooperative ...cooperative);
    public CooperativeDto getCooperative(long id);
    public List<CooperativeDto> FilterByRegion(String cooperative);
    public void deleteCooperative(Long id);
    public List<CooperativeDto> getAll();
    public CooperativeDto getCooperativeByName(String name);

    public List<CooperativeDto> getCooperativeByNameContaining(String name);

    void update(Cooperative cooperative);
}
