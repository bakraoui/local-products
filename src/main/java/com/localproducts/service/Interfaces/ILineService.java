package com.localproducts.service.Interfaces;

import com.localproducts.dto.lineCommandDto.LineCommandResponse;
import com.localproducts.entities.LineCommand;

import java.util.List;

public interface ILineService {

    void create(LineCommand line);
    void delete(LineCommand line);
    void deleteById(Long id);
    LineCommandResponse findById(Long id);
    List<LineCommandResponse> findByProduct(Long productId);
    List<LineCommandResponse> findByCommand(Long commandId);

    void update(LineCommand lineCommand);
}
