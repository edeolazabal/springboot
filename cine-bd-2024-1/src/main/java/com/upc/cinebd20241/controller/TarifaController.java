package com.upc.cinebd20241.controller;

import com.upc.cinebd20241.model.Compra;
import com.upc.cinebd20241.model.Tarifa;
import com.upc.cinebd20241.service.TarifaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarifa")
public class TarifaController {
    // Obtener Todos los registro
    final TarifaService tarifaService;

    public TarifaController(TarifaService tarifaService) {
        this.tarifaService = tarifaService;
    }

    @GetMapping
    public ResponseEntity<List<Tarifa>> lista() {
             return new ResponseEntity<>(tarifaService.lista(), HttpStatus.OK);
        }

    // Obtener un registro por Id
    // Adicionar un registro
    @PostMapping
    public ResponseEntity<Tarifa> inserta (@RequestBody Tarifa tarifa) {
        return new ResponseEntity<>(tarifaService.inserta(tarifa), HttpStatus.CREATED);
    }

}
