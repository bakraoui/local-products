package com.localproducts.Controllers;

import com.localproducts.dto.regionDto.CreateRegionRequest;
import com.localproducts.dto.regionDto.RegionResponse;
import com.localproducts.service.Implementation.RegionService;
import com.localproducts.service.Interfaces.IRegionService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/regions")
public class RegionController {
    private final IRegionService regionService;
    public RegionController( IRegionService regionService){
        this.regionService = regionService;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody CreateRegionRequest request){
        regionService.save(request);
    }

    @GetMapping("")
    public List<RegionResponse> getAll(){
        return regionService.findAll();
    }


    @GetMapping("/{id}")
    public RegionResponse getById(@PathVariable Long id){
        return regionService.getById(id);
    }

    @GetMapping("/name/{name}")
    public RegionResponse getByName(@PathVariable String name){
        return regionService.getByName(name);
    }
}
