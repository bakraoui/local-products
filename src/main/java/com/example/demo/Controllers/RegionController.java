package com.example.demo.Controllers;

import com.example.demo.dto.RegionDto;
import com.example.demo.entities.Region;
import com.example.demo.service.Implementation.RegionImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/regions")
public class RegionController {
    RegionImp regionImp;
    @Autowired
    public RegionController(RegionImp regionImp){
        this.regionImp=regionImp;
    }

    @GetMapping("")
    public List<RegionDto> getAllRegion(){
        List<RegionDto> regions = regionImp.findAllRegion();
        return regions;
    }

    @PostMapping()
    public String  addRegion(@RequestBody Region ...region){
        try {
            regionImp.addRegions(region);
            return " added successfully";
        }catch (Exception e){
            return e.getMessage();
        }
    }

    @GetMapping("/{id}")
    public RegionDto getById(@PathVariable Long id){
        return regionImp.getById(id);
    }

    @GetMapping("/name/{name}")
    public RegionDto getByName(@PathVariable String name){
        return regionImp.getRegionByName(name);
    }
}
