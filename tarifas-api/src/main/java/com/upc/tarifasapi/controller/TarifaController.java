package com.upc.tarifasapi.controller;

import com.upc.tarifasapi.model.entity.Tarifa;
import com.upc.tarifasapi.service.TarifaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarifa")
public class TarifaController {
    @Autowired
    public final TarifaService tarifaService;

    public TarifaController(TarifaService tarifaService) {
        this.tarifaService = tarifaService;
    }
    @GetMapping
    public ResponseEntity<List<Tarifa>> lista() { return new ResponseEntity<>(tarifaService.lista(), HttpStatus.OK); }

    @GetMapping("/precioMaximo")
    public ResponseEntity<?> precioMaximo() { return new ResponseEntity<>(tarifaService.precioMaximo(), HttpStatus.OK); }

    @PostMapping
    public ResponseEntity<Tarifa> inserta(@RequestBody Tarifa tarifa) { return new ResponseEntity<>(tarifaService.inserta(tarifa), HttpStatus.CREATED); }

    @PutMapping("/{id}")
    public ResponseEntity<Tarifa> modifica(@PathVariable Long id, @RequestBody Tarifa tarifa) throws Exception { return new ResponseEntity<>(tarifaService.modifica(id, tarifa), HttpStatus.OK); }

    @DeleteMapping("/{id}")
    public ResponseEntity<Tarifa> elimina(@PathVariable Long id) throws Exception { return new ResponseEntity<>(tarifaService.elimina(id), HttpStatus.OK); }

}
