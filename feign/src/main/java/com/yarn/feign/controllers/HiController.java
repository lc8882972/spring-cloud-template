package com.yarn.feign.controllers;

import com.yarn.feign.services.SayHiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
public class HiController {
    private static final Logger log = Logger.getLogger(HiController.class.getName());
    @Autowired
    SayHiService service;

    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    public String sayHi(@RequestParam String name){
        log.log(Level.INFO, "you called home");
        return service.sayHiFromClientOne();
    }
}
