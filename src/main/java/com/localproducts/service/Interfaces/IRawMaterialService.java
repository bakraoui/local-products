package com.localproducts.service.Interfaces;


import com.localproducts.dto.rawMaterialDto.CreateRawMaterialRequest;
import com.localproducts.dto.rawMaterialDto.RawMaterialResponse;
import com.localproducts.entities.RawMaterial;

import java.util.List;

public  interface IRawMaterialService {


    void create(CreateRawMaterialRequest request);

    RawMaterialResponse getById(Long id);

    RawMaterialResponse getByName(String name);

    void update(RawMaterial rawMaterial);

    void delete(RawMaterial rawMaterial);

    void deleteById(Long id);

    List<RawMaterialResponse> getAll();
}
