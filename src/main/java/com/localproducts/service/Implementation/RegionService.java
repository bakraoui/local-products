package com.localproducts.service.Implementation;

import com.localproducts.dto.regionDto.CreateRegionRequest;
import com.localproducts.dto.regionDto.RegionResponse;
import com.localproducts.entities.Region;
import com.localproducts.exceptions.RecordExistException;
import com.localproducts.exceptions.RecordNotExistException;
import com.localproducts.mappers.RegionMapper;
import com.localproducts.repositories.RegionRepository;
import com.localproducts.service.Interfaces.IRegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class RegionService implements IRegionService {

    @Autowired
    RegionRepository regionRepository;

    @Override
    public void save(CreateRegionRequest request){
        Optional<Region> optionalRegion = regionRepository.findByName(request.getName());

        if (optionalRegion.isPresent()){
            throw new RecordExistException("Region already exist");
        }

        Region region = RegionMapper.regionRequestToRegion(request);
        regionRepository.save(region);
    }

    @Override
    public RegionResponse getById(Long id) {
        Region region = regionRepository.findById(id)
                .stream().findFirst()
                .orElseThrow(() -> new RecordNotExistException("No region Found with the given Id"));
        return RegionMapper.regionToRegionResponse(region);
    }

    @Override
    public RegionResponse getByName(String name){
        Region region = regionRepository.findByName(name)
                .stream().findFirst().orElseThrow(() -> new RecordNotExistException("No region Found with the given Name"));
        return  RegionMapper.regionToRegionResponse(region);
    }

    @Override
    public List<RegionResponse> findAll() {
        List<Region> regions = regionRepository.findAll();
        return regions.stream()
                .map(RegionMapper::regionToRegionResponse)
                .collect(Collectors.toList());
    }


    @Override
    public void delete(Long id){
        Region region = regionRepository.findById(id)
                .stream().findFirst()
                .orElseThrow(() -> new RecordNotExistException("No region Found with the given Id"));
        regionRepository.delete(region);

    }


}
