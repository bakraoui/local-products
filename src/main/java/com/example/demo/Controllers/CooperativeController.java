package com.example.demo.Controllers;

import com.example.demo.dto.CooperativeDto;
import com.example.demo.entities.Cooperative;
import com.example.demo.service.Implementation.CooperativeImp;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@RestController
@RequestMapping("/api/cooperatives")
public class CooperativeController {
    @Autowired
    CooperativeImp cooperativeImp;

    @PostMapping("")
    public String addCooperative(@RequestBody Cooperative ...cooperative){
        try {
            cooperativeImp.addCooperatives(cooperative);
            return "Cooperative added with success";
        }catch (Exception e){
            return e.getMessage();
        }
    }

    @GetMapping("")
    public List<CooperativeDto> getCooperative(){
        List<CooperativeDto> cooperatives =  cooperativeImp.getAll();
        return cooperatives;
    }

    @GetMapping("/name/{name}")
    public List<CooperativeDto> getCooperativeByName(@PathVariable String name){
        List<CooperativeDto> cooperatives =  cooperativeImp.getCooperativeByNameContaining(name);
        return cooperatives;
    }

    @GetMapping("/{id}")
    public CooperativeDto getCooperativeById(@PathVariable Long id){
        CooperativeDto cooperatives =  cooperativeImp.getCooperative(id);
        return cooperatives;
    }

    @DeleteMapping("/{id}")
    public String deleteCooperative(@PathVariable("id") Long id){
        try {
            cooperativeImp.deleteCooperative(id);
            return "Cooperative deleted suuccessfully";
        }catch (Exception e){
            return e.getMessage();
        }
    }

    @PutMapping("")
    public String updateCooperative(@RequestBody Cooperative cooperative){
        try {
            cooperativeImp.update(cooperative);
            return "Cooperative updated successfully";
        }catch (Exception e){
            return e.getMessage();
        }

    }
}
