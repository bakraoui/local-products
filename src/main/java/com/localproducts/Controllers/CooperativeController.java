package com.localproducts.Controllers;

import com.localproducts.dto.cooperativeDto.CooperativeResponse;
import com.localproducts.dto.cooperativeDto.CreateCooperativeRequest;
import com.localproducts.entities.Cooperative;
import com.localproducts.service.Implementation.CooperativeService;

import com.localproducts.service.Interfaces.ICooperativeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/cooperatives")
public class CooperativeController {
    private final ICooperativeService cooperativeService;

    public CooperativeController(CooperativeService cooperativeService) {
        this.cooperativeService = cooperativeService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody CreateCooperativeRequest request){
        cooperativeService.save(request);
    }

    @GetMapping
    public List<CooperativeResponse> getAll(){
        return cooperativeService.getAll();
    }


    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CooperativeResponse getCooperativeById(@PathVariable Long id){
        return cooperativeService.getCooperative(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id){
        cooperativeService.deleteCooperative(id);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void update(@RequestBody Cooperative cooperative){
        cooperativeService.update(cooperative);
    }
}
