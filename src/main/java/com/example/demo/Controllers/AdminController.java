package com.example.demo.Controllers;


import com.example.demo.entities.Admin;
import com.example.demo.service.Implementation.AdminImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    AdminImp adminImp;

    @PostMapping
    public void add(@RequestBody Admin admin){
        adminImp.addAdmin(admin);
    }
}
