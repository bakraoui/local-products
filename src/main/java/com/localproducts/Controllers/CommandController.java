package com.localproducts.Controllers;

import com.localproducts.dto.commandDto.CommandResponse;
import com.localproducts.entities.Command;
import com.localproducts.service.Interfaces.ICommandService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/commands")
public class CommandController {

    private final ICommandService commandService;

    public CommandController(ICommandService commandService) {
        this.commandService = commandService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Command command){
        commandService.create(command);
    }

    @GetMapping("")
    public List<CommandResponse> getAll(){
        return commandService.getAll();
    }


    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<CommandResponse> getCommandById(@PathVariable Long id){
        return commandService.getAll();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id){
        commandService.deleteById(id);
    }

    @PutMapping("")
    @ResponseStatus(HttpStatus.OK)
    public void update(@RequestBody Command command){
            commandService.update(command);
    }
}
