package com.upc.tarifasapi.controller;

import com.upc.tarifasapi.model.entity.Compra;
import com.upc.tarifasapi.service.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/compra")
public class CompraController {
    @Autowired
    private final CompraService compraService;

    public CompraController(CompraService compraService) {
        this.compraService = compraService;
    }
    @GetMapping
    public ResponseEntity<List<Compra>> lista() { return new ResponseEntity<>(compraService.lista(), HttpStatus.OK); }

    @PostMapping
    public ResponseEntity<Compra> inserta(@RequestBody Compra compra) { return new ResponseEntity<>(compraService.inserta(compra), HttpStatus.CREATED); }
}
