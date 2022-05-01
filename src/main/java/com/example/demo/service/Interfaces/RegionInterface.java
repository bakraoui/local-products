package com.example.demo.service.Interfaces;

import com.example.demo.dto.RegionDto;
import com.example.demo.entities.Region;

import java.util.List;


public interface RegionInterface {

    public void addRegion(Region region);
    public void addRegions(Region ...region);
    public RegionDto getRegionByName(String region);

    public List<RegionDto> findAllRegion();

    boolean deleteRegion(Long id);

    RegionDto getById(Long id);
}
