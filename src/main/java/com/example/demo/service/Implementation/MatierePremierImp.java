package com.example.demo.service.Implementation;

import com.example.demo.dto.MatiereDto;
import com.example.demo.dto.ToDto;
import com.example.demo.entities.MatierePremiere;
import com.example.demo.repositories.MatierePremiereRepository;
import com.example.demo.service.Interfaces.MatierePremiereInterface;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class MatierePremierImp implements MatierePremiereInterface {

    @Autowired
    MatierePremiereRepository matierePremiereRepository;

    @Override
    public void create(MatierePremiere ...matierePremiere) {
        int i =0;
        for (MatierePremiere mp : matierePremiere ) {
            Optional<MatierePremiere> m = matierePremiereRepository.findByName(mp.getName());
            if (!m.isPresent()) matierePremiereRepository.save(mp);
            else i++;
        }
        if (i != 0) throw new IllegalStateException("data already exist");
    }

    @Override
    public MatiereDto getById(long id) {
        MatierePremiere matierePremiere =  matierePremiereRepository.findById(id)
                .stream().findFirst().orElse(null);

        return ToDto.toMatiereDto(matierePremiere);
    }

    @Override
    public MatiereDto getByName(String name){
        MatierePremiere matierePremiere =  matierePremiereRepository.findByName(name)
                .stream().findFirst().orElse(null);

        return ToDto.toMatiereDto(matierePremiere);
    }

    @Override
    public void update(MatierePremiere matierePremiere){
        Optional<MatierePremiere> matierePremiereOptional =
                matierePremiereRepository.findByName(matierePremiere.getName());
        if (matierePremiereOptional.isPresent())
            throw new IllegalStateException("Matiere deja existe");
        else matierePremiereRepository.save(matierePremiere);
    }

    @Override
    public void delete(MatierePremiere matierePremiere) {
        matierePremiereRepository.delete(matierePremiere);
    }

    @Override
    public void deleteById(Long id){
        matierePremiereRepository.deleteById(id);
    }

    @Override
    public List<MatiereDto> getAll() {
        List<MatierePremiere> matieres = matierePremiereRepository.findAll();
        List<MatiereDto> matiereDtos = new ArrayList<>();
        for (MatierePremiere m: matieres ) {
            matiereDtos.add(ToDto.toMatiereDto(m));
        }
        return matiereDtos;
    }


}
