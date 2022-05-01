package com.example.demo.service.Implementation;

import com.example.demo.dto.CommandDto;
import com.example.demo.dto.ToDto;
import com.example.demo.entities.Command;
import com.example.demo.repositories.CommandRepository;
import com.example.demo.service.Interfaces.CommandInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommandImp implements CommandInterface {

    @Autowired
    CommandRepository commandRepository;

    @Override
    public void create(Command command){
        commandRepository.save(command);
    }

    public CommandDto getById(Long id){
        Command command =  commandRepository.findById(id)
                .stream().findFirst().orElse(null);
        return ToDto.toCommandDto(command);
    }

    @Override
    public List<CommandDto> getAll(){
        List<Command> commands = commandRepository.findAll() ;
        List<CommandDto> commandDtos = new ArrayList<>();
        for (Command command : commands ) {
            commandDtos.add(ToDto.toCommandDto(command));
        }
        return commandDtos;
    }

    @Override
    public void update(Command command){
        commandRepository.save(command);
    }

    @Override
    public void delete(Command command){
        commandRepository.delete(command);
    }

    @Override
    public void deleteById(Long id){
        commandRepository.deleteById(id);
    }

}
