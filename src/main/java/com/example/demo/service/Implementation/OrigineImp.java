package com.example.demo.service.Implementation;


import com.example.demo.dto.LigneCommandDto;
import com.example.demo.dto.OrigineDto;
import com.example.demo.dto.ToDto;
import com.example.demo.entities.Origine;
import com.example.demo.repositories.OrigineRepository;
import com.example.demo.service.Interfaces.OrigineInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrigineImp implements OrigineInterface {

    @Autowired
    OrigineRepository origineRepository;

    @Override
    public void addOrigines(Origine...origines) {
        int i=0;
        for (Origine origine : origines ) {
            String name = origine.getLabel();
            Origine org = origineRepository.findByLabel(name);
            if (org == null) origineRepository.save(origine );
            else i++;
        }
        if (i!=0) throw new IllegalStateException("data saved");
    }
    @Override
    public List<OrigineDto> getAllOrigines() {
        List<Origine> origines = origineRepository.findAll();
        List<OrigineDto> origineDtos = new ArrayList<>();
        for (Origine origine : origines ) {
            origineDtos.add(ToDto.toOrigineDto(origine));
        }
        return origineDtos;
    }

    @Override
    public OrigineDto getOrigine(long id) {
        Origine origine = origineRepository.getById((long) id);
        return ToDto.toOrigineDto(origine);
    }

    @Override
    public OrigineDto getByName(String label) {
        Origine origine = origineRepository.findByLabel(label);
        return ToDto.toOrigineDto(origine);
    }

    @Override
    public void updateOrigine(Origine origine) {
        Origine optionalOrigine = origineRepository.findByLabel(origine.getLabel());
        if (optionalOrigine == null)  origineRepository.save( origine);
        else throw new IllegalStateException("Origine already exist");
    }

    @Override
    public void delete(Origine origine){
        origineRepository.delete(origine);
    }

    @Override
    public void deleteById(Long id){
        origineRepository.deleteById(id);
    }

    @Override
    public OrigineDto getById(Long id) {
        Origine origine = origineRepository.findById(id)
                .stream().findFirst().orElse(null);

        return ToDto.toOrigineDto(origine);
    }
}
