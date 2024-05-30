package com.upc.datajpa20241.controller;

import com.upc.datajpa20241.model.Persona;
import com.upc.datajpa20241.service.PersonaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PersonaController {

    private final PersonaService personaService;

    public PersonaController(PersonaService personaService) {
        this.personaService = personaService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Persona>> getPersona(@PathVariable int id) {
        return new ResponseEntity<>(personaService.getPersona(id), HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<Persona>> getTodas() {
        return new ResponseEntity<>(personaService.getTodas(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Persona> agrega(@RequestBody Persona pers) {
        return new ResponseEntity<>(personaService.agrega(pers), HttpStatus.CREATED);
    }
}
