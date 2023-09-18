package com.localproducts.service.Implementation;

import com.localproducts.dto.commandDto.CommandResponse;
import com.localproducts.entities.Command;
import com.localproducts.exceptions.RecordNotExistException;
import com.localproducts.mappers.CommandMapper;
import com.localproducts.repositories.CommandRepository;
import com.localproducts.service.Interfaces.ICommandService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommandService implements ICommandService {

    private final CommandRepository commandRepository;

    public CommandService(CommandRepository commandRepository) {
        this.commandRepository = commandRepository;
    }

    @Override
    public void create(Command command){
        commandRepository.save(command);
    }

    public CommandResponse getById(Long id){
        Command command =  commandRepository.findById(id)
                .stream().findFirst().orElseThrow(() -> new RecordNotExistException("Command with given Id not found"));
        return CommandMapper.commandToCommandResponse(command);
    }

    @Override
    public List<CommandResponse> getAll(){
        List<Command> commands = commandRepository.findAll() ;
        return commands.stream()
                .map(CommandMapper::commandToCommandResponse)
                .collect(Collectors.toList());
    }

    @Override
    public void update(Command command){
        commandRepository.save(command);
    }


    @Override
    public void deleteById(Long id){
        commandRepository.deleteById(id);
    }

}
