package com.localproducts.service.Interfaces;

import com.localproducts.dto.commandDto.CommandResponse;
import com.localproducts.entities.Command;

import java.util.List;

public interface ICommandService {
    void create(Command command);

    List<CommandResponse> getAll();

    void update(Command command);

    void deleteById(Long id);
}
