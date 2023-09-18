package com.localproducts.service.Implementation;

import com.localproducts.dto.rawMaterialDto.CreateRawMaterialRequest;
import com.localproducts.dto.rawMaterialDto.RawMaterialResponse;
import com.localproducts.entities.Origin;
import com.localproducts.entities.RawMaterial;
import com.localproducts.exceptions.RecordNotExistException;
import com.localproducts.mappers.OriginMapper;
import com.localproducts.mappers.RawMaterialMapper;
import com.localproducts.repositories.OriginRepository;
import com.localproducts.repositories.RawMaterialRepository;
import com.localproducts.service.Interfaces.IRawMaterialService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RawMaterialService implements IRawMaterialService {

    private final RawMaterialRepository rawMaterialRepository;
    private final OriginRepository originRepository;

    public RawMaterialService(RawMaterialRepository rawMaterialRepository, OriginRepository originRepository) {
        this.rawMaterialRepository = rawMaterialRepository;
        this.originRepository = originRepository;
    }

    @Override
    public void create(CreateRawMaterialRequest request) {
       Origin origin = originRepository.findById(request.getOriginId())
               .stream().findFirst()
               .orElseThrow(() -> new RecordNotExistException("No origin found with the given Id"));
        RawMaterial rawMaterial = RawMaterialMapper.createRawMaterialRequestToRawMaterial(request, origin);
        rawMaterialRepository.save(rawMaterial);
    }

    @Override
    public RawMaterialResponse getById(Long id) {
        RawMaterial rawMaterial =  rawMaterialRepository.findById(id)
                .stream().findFirst()
                .orElseThrow(() -> new RecordNotExistException("No Raw Material found with the given Id"));

        return RawMaterialMapper.rawMaterialToRawMaterialResponse(rawMaterial);
    }

    @Override
    public RawMaterialResponse getByName(String name){
        RawMaterial rawMaterial =  rawMaterialRepository.findByName(name)
                .stream().findFirst()
                .orElseThrow(() -> new RecordNotExistException("No Raw Material found with the given Name"));

        return RawMaterialMapper.rawMaterialToRawMaterialResponse(rawMaterial);
    }

    @Override
    public void update(RawMaterial rawMaterial){
        Optional<RawMaterial> matierePremiereOptional =
                rawMaterialRepository.findByName(rawMaterial.getName());
        if (matierePremiereOptional.isPresent())
            throw new IllegalStateException("Matiere deja existe");
        else rawMaterialRepository.save(rawMaterial);
    }

    @Override
    public void delete(RawMaterial rawMaterial) {
        rawMaterialRepository.delete(rawMaterial);
    }

    @Override
    public void deleteById(Long id){
        rawMaterialRepository.deleteById(id);
    }

    @Override
    public List<RawMaterialResponse> getAll() {
       List<RawMaterial> rawMaterials = rawMaterialRepository.findAll();
       return rawMaterials.stream()
               .map(RawMaterialMapper::rawMaterialToRawMaterialResponse)
               .collect(Collectors.toList());
    }


}
