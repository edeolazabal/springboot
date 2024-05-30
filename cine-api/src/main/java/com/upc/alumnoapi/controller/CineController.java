package com.upc.alumnoapi.controller;

import com.upc.alumnoapi.model.Cine;
import com.upc.alumnoapi.model.IBoletaCine;
import com.upc.alumnoapi.model.Ticket;
import com.upc.alumnoapi.service.CineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/test2")
public class CineController {

    @Autowired
    private CineService cineService;

    @GetMapping("/cines")
    public ResponseEntity<List<Cine>> getAllCines() {
        return new ResponseEntity<List<Cine>>(cineService.getAllCines(), HttpStatus.OK);
    }
    @GetMapping("/cines/{id}")
    public ResponseEntity<Cine> getCine(@PathVariable(value = "id") Long cineId) {
        return new ResponseEntity<Cine>(cineService.getCine(cineId), HttpStatus.OK);
    }
    @GetMapping("/ticket/{id}")
    public ResponseEntity<Ticket> getByCategoria(@PathVariable(value = "id") Long categoriaId, @RequestParam Integer cantidad) {
        return new ResponseEntity<Ticket>(cineService.getByCategoria(cantidad, categoriaId), HttpStatus.OK);
    }
    @GetMapping("/ticketall/{cantidad}")
    public ResponseEntity<List<Ticket>> getAllCategoria(@PathVariable (value = "cantidad") Integer cantidad) {
        return new ResponseEntity<List<Ticket>>(cineService.getAllCategoria(cantidad), HttpStatus.OK);
    }
    @GetMapping("/cinenombre/{nombre}")
    public ResponseEntity<List<Cine>> findByCategory(@PathVariable (value = "nombre") String name) {
        return new ResponseEntity<List<Cine>>(cineService.findByCategory(name), HttpStatus.OK);
    }
    @PostMapping("/cines")
    public ResponseEntity<Cine> insertCine (@RequestBody Cine cine) {
        return new ResponseEntity<Cine>(cineService.insertCine(cine), HttpStatus.CREATED);
    }
    @PutMapping("/cines/{id}")
    public ResponseEntity<Cine> updateCine (@PathVariable (value = "id") Long cineId, @RequestBody Cine cine) {
        return new ResponseEntity<Cine>(cineService.updateCine(cineId, cine), HttpStatus.OK);
    }
    @DeleteMapping("/cines/{id}")
    public ResponseEntity<Cine> deleteCine (@PathVariable (value = "id") Long cineId) {
        return new ResponseEntity<Cine>(cineService.deleteCine(cineId), HttpStatus.NO_CONTENT);
    }
}
