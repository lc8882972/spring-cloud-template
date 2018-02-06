package com.yarn.feign.services;

import org.springframework.stereotype.Component;

@Component
public class SayHiServiceHystric implements SayHiService {
    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry "+name;
    }
}