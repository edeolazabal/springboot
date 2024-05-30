package com.upc.catprodapi.controller;

import com.upc.catprodapi.model.Cat;
import com.upc.catprodapi.model.Prod;
import com.upc.catprodapi.service.CatService;
import com.upc.catprodapi.service.ProdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prod")
public class ProdController {

    @Autowired
    private final ProdService prodService;

    public ProdController(ProdService prodService) {
        this.prodService = prodService;
    }

    @GetMapping
    public ResponseEntity<List<Prod>> lista() {
        return new ResponseEntity<>(prodService.lista(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Prod> inserta(@RequestBody Prod prod) {
        return new ResponseEntity<>(prodService.inserta(prod), HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Prod> consultaPorId(@PathVariable(value = "id") Long id) throws Exception {
        return new ResponseEntity<>(prodService.obtieneUnaCat(id), HttpStatus.OK);

    }
}
