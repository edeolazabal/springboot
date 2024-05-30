package com.upc.cinebdapi.controller;

import com.upc.cinebdapi.model.Compra;
import com.upc.cinebdapi.model.Tarifa;
import com.upc.cinebdapi.service.CompraService;
import com.upc.cinebdapi.service.TarifaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarifa")
public class TarifaController {
    @Autowired
    private final TarifaService tarifaService;

    public TarifaController(TarifaService tarifaService) {
        this.tarifaService = tarifaService;
    }
    @GetMapping
    public ResponseEntity<List<Tarifa>> lista() {
        return new ResponseEntity<>(tarifaService.lista(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Tarifa> inserta (@RequestBody Tarifa tarifa) {
        return new ResponseEntity<>(tarifaService.inserta(tarifa), HttpStatus.CREATED);
    }
}
