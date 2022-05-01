package com.example.demo.Controllers;

import com.example.demo.dto.CommandDto;
import com.example.demo.entities.Command;
import com.example.demo.service.Implementation.CommandImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/commands")
public class CommandController {

    @Autowired
    CommandImp commandImp;

    @PostMapping("")
    public String addCommand(@RequestBody Command command){
        try {
            commandImp.create(command);
            return "Command added with success";
        }catch (Exception e){
            return e.getMessage();
        }
    }

    @GetMapping("")
    public List<CommandDto> getCommand(){
        return commandImp.getAll();
    }


    @GetMapping("/{id}")
    public CommandDto getCommandById(@PathVariable Long id){
        return  commandImp.getById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteCommand(@PathVariable("id") Long id){
        try {
            commandImp.deleteById(id);
            return "Cooperative deleted suuccessfully";
        }catch (Exception e){
            return e.getMessage();
        }
    }

    @PutMapping("")
    public String updateCommand(@RequestBody Command command){
        try {
            commandImp.update(command);
            return "Cooperative updated successfully";
        }catch (Exception e){
            return e.getMessage();
        }

    }
}
