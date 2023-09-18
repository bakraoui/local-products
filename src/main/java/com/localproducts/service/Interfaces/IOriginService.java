package com.localproducts.service.Interfaces;

import com.localproducts.dto.originDto.CreateOriginRequest;
import com.localproducts.dto.originDto.OriginResponse;
import com.localproducts.entities.Origin;

import java.util.List;

public interface IOriginService {

    void create(CreateOriginRequest request);
    List<OriginResponse> getAll();

    OriginResponse getById(Long id);

    OriginResponse getByName(String label);

    void delete(Origin origin);


}
