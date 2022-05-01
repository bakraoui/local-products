package com.example.demo.Controllers;

import com.example.demo.dto.OrigineDto;
import com.example.demo.entities.Origine;
import com.example.demo.service.Implementation.OrigineImp;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@NoArgsConstructor
@RequestMapping("/api/origines")
public class OrigineController {

    @Autowired
    OrigineImp origineImp;

    @GetMapping("")
    public List<OrigineDto> getAllOrigines(){
        List<OrigineDto> regions = origineImp.getAllOrigines();
        return regions;
    }

    @PostMapping("")
    public String addOrigines(@RequestBody Origine ...origines){
        try {
            origineImp.addOrigines(origines);
            return "added";
        }catch (Exception e){
            return e.getMessage();
        }
    }

    @GetMapping("/{id}")
    public OrigineDto getById(@PathVariable Long id){
        return origineImp.getById(id);
    }

    @GetMapping("/name/{name}")
    public OrigineDto getByName(@PathVariable String name){
        return origineImp.getByName(name);
    }
}
