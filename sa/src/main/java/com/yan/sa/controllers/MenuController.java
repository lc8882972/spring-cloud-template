package com.yan.sa.controllers;

import com.yan.sa.entities.Menu;
import com.yan.sa.services.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class MenuController {
    @Autowired
    private MenuService service;

    @PostMapping(path = "/menus")
    public boolean create(@RequestParam String name, @RequestParam String description, @RequestParam(required = false) String url, @RequestParam(required = false) Long parent){
        Menu menu = new Menu();
        menu.setName(name);
        menu.setDescription(description);
        menu.setUrl(url);
        menu.setParentNode(parent);
        menu.setCreateTime(new Date());
        menu.setEnabled(true);
        return service.create(menu);
    }

    @GetMapping(path = "/menus")
    public List<Menu> get(){
        return service.list();
    }
}
