package com.example.demo.Controllers;

import com.example.demo.dto.MatiereDto;
import com.example.demo.entities.MatierePremiere;
import com.example.demo.service.Implementation.MatierePremierImp;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@RestController
@RequestMapping("/api/matiere")
public class MatierePremiereController {

    @Autowired
    MatierePremierImp matierePremierImp;

    @PostMapping("")
    public  String create(@RequestBody MatierePremiere ...matierePremiere){
        try {
            matierePremierImp.create(matierePremiere);
            return "successfully added";
        }catch (Exception e){
            return e.getMessage();
        }

    }

    @GetMapping("")
    public List<MatiereDto> getAll(){
        return matierePremierImp.getAll();
    }

    @GetMapping("/{id}")
    public MatiereDto getById(@PathVariable Long id){
        return matierePremierImp.getById(id);
    }

    @GetMapping("/name/{name}")
    public MatiereDto getByName(@PathVariable String name){
        return matierePremierImp.getByName(name);
    }

    @PutMapping("")
    public void update(@RequestBody MatierePremiere matierePremiere){
        matierePremierImp.update(matierePremiere);
    }

}
