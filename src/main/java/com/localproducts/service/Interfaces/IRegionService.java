package com.localproducts.service.Interfaces;

import com.localproducts.dto.regionDto.CreateRegionRequest;
import com.localproducts.dto.regionDto.RegionResponse;
import com.localproducts.entities.Region;

import java.util.List;


public interface IRegionService {

    void save(CreateRegionRequest request);
    RegionResponse getByName(String region);

    List<RegionResponse> findAll();

    void delete(Long id);

    RegionResponse getById(Long id);
}
