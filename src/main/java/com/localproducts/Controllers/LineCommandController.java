package com.localproducts.Controllers;


import com.localproducts.dto.lineCommandDto.LineCommandResponse;
import com.localproducts.entities.LineCommand;
import com.localproducts.service.Implementation.LineService;
import com.localproducts.service.Interfaces.ILineService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lines")
public class LineCommandController {
    
    private final ILineService lineService;

    public LineCommandController(ILineService lineService) {
        this.lineService = lineService;
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody LineCommand LineCommand){
            lineService.create(LineCommand);

    }


    @GetMapping("/command/{commandId}")
    @ResponseStatus(HttpStatus.OK)
    public List<LineCommandResponse> getByCommand(@PathVariable  Long commandId){
        return lineService.findByCommand(commandId);
    }

    @GetMapping("/product/{productId}")
    @ResponseStatus(HttpStatus.OK)
    public List<LineCommandResponse> getByProduct(@PathVariable Long productId){
        return lineService.findByProduct(productId);
    }


    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public LineCommandResponse getById(@PathVariable Long id){
        return  lineService.findById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id){
        lineService.deleteById(id);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void update(@RequestBody LineCommand LineCommand){
        lineService.update(LineCommand);

    }
    
}
