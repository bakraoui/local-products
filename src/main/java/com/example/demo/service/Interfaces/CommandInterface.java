package com.example.demo.service.Interfaces;

import com.example.demo.dto.CommandDto;
import com.example.demo.entities.Command;

import java.util.List;

public interface CommandInterface {
    void create(Command command);

    List<CommandDto> getAll();

    void update(Command command);

    void delete(Command command);

    void deleteById(Long id);
}
