package com.upc.demo2api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping
public class CalculadoraController {

    @GetMapping("/")
    public String calcula (@RequestParam double op1, @RequestParam double op2, @RequestParam String operador) {
        double resultado = 0.0;
        switch (operador)  {
            case "Mas":
                resultado = (op1 + op2);
                break;
            case "-":
                resultado =  (op1 - op2);
                break;
            case "*":
                resultado =  (op1 * op2);
                break;
            case "/":
                if (op2 == 0) return "no se puede realizar división entre 0";
                resultado =  (op1 / op2);
                break;
        }
        return "El resultado de "+ op1 + " " + operador + " " + op2 + " es " + resultado;
    }

}
