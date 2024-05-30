package com.upc.calculadoraapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class Controller {

    @GetMapping
    public String saludo () {
        return "Hola UPC";
    }
    @GetMapping("/suma")
    public String suma (@RequestParam double op1, @RequestParam double op2) {
        double resultado = op1 + op2;
        return ("La suma de " + op1 + " + " + op2 + " es " + resultado);
    }
    @GetMapping("/resta")
    public String resta (@RequestParam double op1, @RequestParam double op2) {
        double resultado = op1 - op2;
        return ("La resta de " + op1 + " - " + op2 + " es " + resultado);
    }
    @GetMapping("/multiplica")
    public String multiplica (@RequestParam double op1, @RequestParam double op2) {
        double resultado = op1 * op2;
        return ("La multiplicación de " + op1 + " * " + op2 + " es " + resultado);
    }
    @GetMapping("/divide")
    public String divide (@RequestParam double op1, @RequestParam double op2) {
        if (op2 == 0) return "No se puede dividir entre cero";
        double resultado = op1 / op2;
        return ("La división de " + op1 + " / " + op2 + " es " + resultado);
    }    
}
