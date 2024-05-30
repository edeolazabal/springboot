package com.upc.securityapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    @GetMapping("/demo/{name}")
    public String showName (String name){
        return "Hola " + name;
    }

}
