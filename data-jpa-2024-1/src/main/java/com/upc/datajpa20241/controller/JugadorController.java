package com.upc.datajpa20241.controller;

import com.upc.datajpa20241.dto.CuentaJugadorDto;
import com.upc.datajpa20241.service.JugadorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jugador")
public class JugadorController {
    final JugadorService jugadorService;

    public JugadorController(JugadorService jugadorService) {
        this.jugadorService = jugadorService;
    }

    @GetMapping("/obtieneNombre/{id}")
    public ResponseEntity<String> obtieneNombre (@PathVariable Integer id) {
        return new ResponseEntity<>(jugadorService.obtieneNombre(id), HttpStatus.OK);
    }
    @GetMapping("/obtieneNombre2/{id}")
    public ResponseEntity<CuentaJugadorDto> obtieneNombre2 (@PathVariable Integer id) {
        return new ResponseEntity<>(jugadorService.obtieneNombre2(id), HttpStatus.OK);
    }
}
