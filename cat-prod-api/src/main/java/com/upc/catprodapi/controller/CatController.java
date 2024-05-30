package com.upc.catprodapi.controller;

import com.upc.catprodapi.service.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.upc.catprodapi.model.Cat;

import java.util.List;

@RestController
@RequestMapping("/cat")
public class CatController {

    @Autowired
    private final CatService catService;

    public CatController(CatService catService) {
        this.catService = catService;
    }

    @GetMapping
    public ResponseEntity<List<Cat>> lista() {
        return new ResponseEntity<>(catService.lista(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Cat> inserta(@RequestBody Cat cat) {
        return new ResponseEntity<>(catService.inserta(cat), HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Cat> consultaPorId(@PathVariable(value = "id") Long id) throws Exception {
        return new ResponseEntity<>(catService.obtieneUnaCat(id), HttpStatus.OK);

    }
}
