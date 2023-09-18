package com.localproducts.service.Implementation;


import com.localproducts.dto.originDto.CreateOriginRequest;
import com.localproducts.dto.originDto.OriginResponse;
import com.localproducts.entities.Origin;
import com.localproducts.exceptions.RecordNotExistException;
import com.localproducts.mappers.OriginMapper;
import com.localproducts.repositories.OriginRepository;
import com.localproducts.service.Interfaces.IOriginService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OriginService implements IOriginService {

    private final OriginRepository originRepository;

    public OriginService(OriginRepository originRepository) {
        this.originRepository = originRepository;
    }

    @Override
    public void create(CreateOriginRequest request) {

        //TODO: validate inputs

        //TODO: Check if Records Exist


        Origin origin = OriginMapper.originRequestTOrigin(request);

        originRepository.save(origin);
    }
    @Override
    public List<OriginResponse> getAll() {
        List<Origin> origins = originRepository.findAll();
        return origins.stream()
                .map(OriginMapper::originToOriginResponse)
                .collect(Collectors.toList());
    }

    @Override
    public OriginResponse getById(Long id) {
        Origin origin = originRepository.findById(id)
                .stream().findFirst()
                .orElseThrow(() -> new RecordNotExistException("Origin Not Found"));
        return OriginMapper.originToOriginResponse(origin);
    }

    @Override
    public OriginResponse getByName(String label) {
        Origin origin = originRepository.findByLabel(label)
                .stream().findFirst()
                .orElseThrow(() -> new RecordNotExistException("Origin Not Found") );
        return OriginMapper.originToOriginResponse(origin);
    }


    @Override
    public void delete(Origin origin){
        originRepository.delete(origin);
    }


}
