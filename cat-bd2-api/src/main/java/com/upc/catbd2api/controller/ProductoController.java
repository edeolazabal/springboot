package com.upc.catbd2api.controller;

import com.upc.catbd2api.model.Producto;
import com.upc.catbd2api.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/producto")
public class ProductoController {
    @Autowired
    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }
    @GetMapping
    public ResponseEntity<List<Producto>> lista () { return new ResponseEntity<>(productoService.lista(), HttpStatus.OK); }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> listaPorId (@PathVariable Long id) {
        return new ResponseEntity<>(productoService.listaPorId(id), HttpStatus.OK);
    }

    @PostMapping
    public  ResponseEntity<Producto> inserta (@RequestBody Producto producto) {
        return new ResponseEntity<>(productoService.inserta(producto), HttpStatus.CREATED);
    }
}
