package com.upc.sec20241.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping()
public class DemoController {

    private static final Logger logger= LoggerFactory.getLogger(DemoController.class);
    @GetMapping("/mensaje")
    public ResponseEntity<?> getMessage()
    {
        logger.info("obteniendo el mensaje");

        Map<String, String> mensaje = new HashMap<>();
        // 1.
        mensaje.put("saludo", "Hola UPC");
        // Fin 1

        // 2. Autenticación básica
        var auth = SecurityContextHolder.getContext().getAuthentication();

        logger.info("Datos del Usuario: {}", auth.getPrincipal());
        logger.info("Datos de los Roles: {}", auth.getAuthorities());
        logger.info("Está autenticado: {}", auth.isAuthenticated());
        // fIN 2.


//        return ResponseEntity.ok(mensaje);

        return new ResponseEntity<>(mensaje, HttpStatus.OK);
    }
}
