package com.upc.alumnoapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class DemoController {
    @GetMapping("/demo/{name}")
    public String showName (@PathVariable String name) {
        return "Hola " + name;
    }
}
