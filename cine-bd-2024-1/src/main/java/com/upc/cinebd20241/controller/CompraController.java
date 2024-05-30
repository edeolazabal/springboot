package com.upc.cinebd20241.controller;

import com.upc.cinebd20241.dto.Listado;
import com.upc.cinebd20241.dto.Pedido;
import com.upc.cinebd20241.model.Compra;
import com.upc.cinebd20241.model.Tarifa;
import com.upc.cinebd20241.service.CompraService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/compra")
public class CompraController {
    final CompraService compraService;

    public CompraController(CompraService compraService) {
        this.compraService = compraService;
    }
    @GetMapping
    public ResponseEntity<List<Compra>> lista() {
        return new ResponseEntity<>(compraService.lista(), HttpStatus.OK);
    }
    @GetMapping("/listado")
    public ResponseEntity<List<Listado>> listaCompras() {
        return new ResponseEntity<>(compraService.listaCompras(), HttpStatus.OK);
    }

    // Obtener un registro por Id
    // Adicionar un registro
    @PostMapping
    public ResponseEntity<Compra> inserta (@RequestBody Pedido pedido) {
        return new ResponseEntity<>(compraService.inserta(pedido), HttpStatus.CREATED);
    }

}
