package com.upc.demoinicial.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class DemoController {
    @GetMapping("/corto")
    public ResponseEntity<String> nombreCorto() {

        return new ResponseEntity<>("UPC", HttpStatus.OK);
    }

    @GetMapping("/largo")
    public String nombreLargo() {

        return "Universidad Peruana de Ciencias Aplicadas";
    }
    @PostMapping("/corto")
    public String nombreCortoPOST() {

        return "UPC (POST)";
    }

    // Métodos con parámetros en la línea de ejecución
    @GetMapping("/carga/{dato}")
    public String enviaMensaje(@PathVariable String dato) {
        if (dato == null) dato = "Juan";
        return "Hola " + dato;
    }
    @PostMapping("/carga2")
    public String creaNombre(@RequestBody String dato) {
        if (dato.trim().length() == 0) dato = "otro";
        return dato + " OK";
    }
    @GetMapping("/calcula/{a}/{b}/{ope}")
    // @GetMapping("/calcula")
     //   public double calcula(@RequestParam double a, @RequestParam double b, @RequestParam String ope) {
        public double calcula(@PathVariable double a, @PathVariable double b, @PathVariable String ope) {
        double salida = 0;
        switch (ope) {
            case "+":
                salida = a + b;
                break;
            case "-":
                salida = a - b;
                break;
            case "*":
                salida = a * b;
                break;
            case "/":
                salida = (a * 1.0) / (b * 1.0);
                break;
            default:
                salida = 999;
                break;
        }
        return salida;

    }

    @PostMapping("/calculadora2")
    public double calculadora2(@RequestParam double numero1,@RequestParam String operador,@RequestParam double numero2){
        double resultado=0;
        System.out.println("operador " + operador);
        switch(operador){
            case "+":
                System.out.println("operador entra " + operador);
                resultado=numero1+numero2;
                break;
            case "*":
                resultado=numero1*numero2;
                break;
            case "-":
                resultado=numero1-numero2;
                break;
            case "/":
                resultado=numero1/numero2;
                break;
        }
        return resultado;

    }
}
