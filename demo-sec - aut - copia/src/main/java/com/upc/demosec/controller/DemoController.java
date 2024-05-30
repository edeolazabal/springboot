package com.upc.demosec.controller;

import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableMethodSecurity(prePostEnabled = true)
public class DemoController {
    @GetMapping("/demo/{name}")
    public String showDemo(@PathVariable String name) {
        if (name .length() < 2) { return "Hola UPC"; }
        return "Hola " + name;
    }

    @GetMapping("/preauth/{name}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String showPreAuth (@PathVariable String name) {
        System.out.println("Valor proporcionado: "+ name);
        if (name.length() < 2) { return "Hola UPC"; }
        return "Hola " + name;
    }

    @GetMapping("/postauth/{name}")
    @PostAuthorize("hasAuthority('WRITE')")
    public String showPostAuth (@PathVariable String name) {
        System.out.println("Valor proporcionado (Post): "+ name);
        if (name.length() < 2) { return "Hola UPC"; }
        return "Hola " + name;
    }

}
