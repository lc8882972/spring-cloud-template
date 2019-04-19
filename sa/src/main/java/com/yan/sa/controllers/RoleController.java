package com.yan.sa.controllers;

import com.yan.sa.entities.Role;
import com.yan.sa.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class RoleController {

    @Autowired
    RoleService service;

    @PostMapping(path = "/role")
    public boolean create(@RequestParam String name, @RequestParam String description){

        Role role = new Role();
        role.setName(name);
        role.setDescription(description);
        role.setCreateTime(new Date());
        role.setEnabled(true);
        return service.create(role);
    }
}
