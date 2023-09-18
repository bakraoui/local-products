package com.localproducts.service.Interfaces;

import com.localproducts.dto.cooperativeDto.CooperativeResponse;
import com.localproducts.dto.cooperativeDto.CreateCooperativeRequest;
import com.localproducts.entities.Cooperative;

import java.util.List;

public interface ICooperativeService {
    void save(CreateCooperativeRequest request);

    CooperativeResponse getCooperative(Long id);

    void deleteCooperative(Long id);

    List<CooperativeResponse> getAll();

    void update(Cooperative cooperative);
}
