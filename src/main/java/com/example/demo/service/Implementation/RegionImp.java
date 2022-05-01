package com.example.demo.service.Implementation;

import com.example.demo.dto.CooperativeDto;
import com.example.demo.dto.RegionDto;
import com.example.demo.dto.ToDto;
import com.example.demo.entities.Cooperative;
import com.example.demo.entities.Region;
import com.example.demo.repositories.RegionRepository;
import com.example.demo.service.Interfaces.RegionInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RegionImp implements RegionInterface {

    @Autowired
    RegionRepository regionRepository;

    @Override
    public void addRegion(Region region){
        String name = region.getName();
        Optional<Region>  reg = regionRepository.findByName(name);
        if(reg.isPresent()) throw new IllegalStateException("Region already exist");
        else regionRepository.save(region);
    }

    @Override
    public void addRegions(Region ...regions){
        int i=0;
        for (Region region:regions) {
            String name = region.getName();
            Optional<Region> reg = regionRepository.findByName(name);
            if(reg.isPresent()) i++;
            else regionRepository.save(region);
        }

        if (i != 0)
            throw new IllegalStateException("some regions already exist");

    }

    @Override
    public List<RegionDto> findAllRegion() {
        List<Region> regions = regionRepository.findAll();
        List<RegionDto> regionDtoList = new ArrayList<>();

        for (Region region :regions) {
            regionDtoList.add(ToDto.toRegionDto(region));
        }
        return regionDtoList;
    }

    @Override
    public RegionDto getRegionByName(String name){
        Region  region = regionRepository.findByName(name)
                .stream().findFirst().orElse(null);
         return  ToDto.toRegionDto(region);
    }

    @Override
    public boolean deleteRegion(Long id){
        Optional<Region> region = regionRepository.findById(id);
        if (region.isPresent()){
            regionRepository.deleteById(id);
            return true;
        }
        else return false;
    }

    @Override
    public RegionDto getById(Long id) {
        Region region = regionRepository.findById(id)
                .stream().findFirst().orElse(null);
        return ToDto.toRegionDto(region);
    }
}
