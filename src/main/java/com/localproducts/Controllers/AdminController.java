package com.localproducts.Controllers;


import com.localproducts.dto.adminDto.CreateAdminRequest;
import com.localproducts.service.Interfaces.IAdminService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private final IAdminService adminService;

    public AdminController(IAdminService adminService) {
        this.adminService = adminService;
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody CreateAdminRequest admin){
        adminService.save(admin);
    }

}
