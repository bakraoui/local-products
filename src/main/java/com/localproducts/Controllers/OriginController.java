package com.localproducts.Controllers;

import com.localproducts.dto.originDto.CreateOriginRequest;
import com.localproducts.dto.originDto.OriginResponse;
import com.localproducts.service.Interfaces.IOriginService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/origins")
public class OriginController {

    private final IOriginService originService;

    public OriginController(IOriginService originService) {
        this.originService = originService;
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody CreateOriginRequest request){
        originService.create(request);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<OriginResponse> getAll(){
        return originService.getAll();
    }

    @GetMapping("/{id}")
    public OriginResponse getById(@PathVariable Long id){
        return originService.getById(id);
    }

    @GetMapping("/name/{name}")
    public OriginResponse getByName(@PathVariable String name){
        return originService.getByName(name);
    }
}
