package com.localproducts.Controllers;

import com.localproducts.dto.rawMaterialDto.CreateRawMaterialRequest;
import com.localproducts.dto.rawMaterialDto.RawMaterialResponse;
import com.localproducts.entities.RawMaterial;
import com.localproducts.service.Implementation.RawMaterialService;
import com.localproducts.service.Interfaces.IRawMaterialService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/raw-materials")
public class RawMaterialController {

    private final IRawMaterialService rawMaterialService;

    public RawMaterialController(IRawMaterialService materialService) {
        this.rawMaterialService = materialService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public  void create(@RequestBody CreateRawMaterialRequest request){
        rawMaterialService.create(request);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<RawMaterialResponse> getAll(){
        return rawMaterialService.getAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public RawMaterialResponse getById(@PathVariable Long id){
        return rawMaterialService.getById(id);
    }

    @GetMapping("/name/{name}")
    @ResponseStatus(HttpStatus.OK)
    public RawMaterialResponse getByName(@PathVariable String name){
        return rawMaterialService.getByName(name);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void update(@RequestBody RawMaterial rawMaterial){
        rawMaterialService.update(rawMaterial);
    }

}
