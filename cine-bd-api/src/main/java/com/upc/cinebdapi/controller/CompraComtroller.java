package com.upc.cinebdapi.controller;

import com.upc.cinebdapi.model.Compra;
import com.upc.cinebdapi.model.CompraDto;
import com.upc.cinebdapi.service.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/compra")
public class CompraComtroller {
    @Autowired
    private final CompraService compraService;

    public CompraComtroller(CompraService compraService) {
        this.compraService = compraService;
    }
    @GetMapping
    public ResponseEntity<List<Compra>> lista() {
        return new ResponseEntity<>(compraService.lista(), HttpStatus.OK);
    }
    @GetMapping("/dto")
    public ResponseEntity<List<CompraDto>> listaDto() {
        return new ResponseEntity<>(compraService.listaDto(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Compra> inserta (@RequestBody Compra compra) {
        return new ResponseEntity<>(compraService.inserta(compra), HttpStatus.CREATED);
    }
    @PostMapping("/dto")
    public ResponseEntity<Compra> insertaDto (@RequestBody CompraDto compraDto) {
        return new ResponseEntity<>(compraService.insertaDto(compraDto), HttpStatus.CREATED);
    }
    @PostMapping("/dto/compra")
    public ResponseEntity<String> insertaCompraDto (@RequestBody CompraDto compraDto) {
        return new ResponseEntity<>(compraService.insertaCompraDto(compraDto), HttpStatus.CREATED);
    }
}
