package com.yan.sa.controllers;

import com.yan.sa.dto.CreateUser;
import com.yan.sa.entities.User;
import com.yan.sa.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class UserController {
    @Autowired
    private UserService service;

    @PostMapping(path = "user")
    public boolean create(@RequestParam String name, @RequestParam long roleId){

        CreateUser dto =new CreateUser();
        dto.setName(name);
        dto.setRoleId(roleId);
        dto.setEnabled(true);
        return  service.create(dto);
    }
}
